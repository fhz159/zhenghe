package com.liantong.integration.test;

import javax.sql.DataSource;

import com.liantong.integration.Application;
import com.liantong.integration.condition.KeywordCondition;
import com.liantong.integration.pojo.*;
import com.liantong.integration.service.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.github.springtestdbunit.dataset.ReplacementDataSetLoader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DbUnitConfiguration(dataSetLoader = ReplacementDataSetLoader.class, databaseConnection = { "testDataSource"})
public class PojoTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private KeywordService keywordService;

	@Autowired
	private UserService userService;

	@Autowired
	private PlanService planService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private ClassesService classesService;
	@Autowired
	private LookService lookService;

	@Test
	@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = "/pojotest/testKeyword.xml")
	@ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED, value = "/pojotest/testKeyword.result.xml")
	@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = "/pojotest/testKeyword.result.xml")
	public void testKeyword() {

		Keyword keyword = keywordService.select(1);
		Assert.assertEquals(12, keyword.getBid().intValue());

		keyword.setBid(keyword.getBid() + 8);
		keywordService.update(keyword);
		Assert.assertEquals(20, keyword.getBid().intValue());

		keyword = keywordService.select(1);
		keywordService.delete(keyword);
	}



	@Test
	@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = "/pojotest/testStudent.xml")
	//@ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED, value = "/pojotest/testStudent.result.xml", connection = "dataSource", override = false)
	//@DatabaseTearDown(type = DatabaseOperation.DELETE, value = "/pojotest/testStudent.result.xml", connection = "dataSource")
	public void testStudentClassesCascade() {
		Student student = studentService.select("mmm");
		Assert.assertEquals("001", student.getClasses().getName());

		Classes classes = new Classes();
		classes.setName("001");
		Collection<Classes> cClasses = classesService.selectAll(classes);
		Assert.assertEquals(1, cClasses.size());

		Student student2 = new Student();
		student2.setName("bill");
		student2.setClasses(cClasses.iterator().next());
		studentService.insert(student2);

		Assert.assertEquals("001", student2.getClasses().getName());
	}

	@Test
	@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = "/pojotest/testKeyword.xml")
	public void testKeywordBathUpdate() {
		KeywordCondition keyword = new KeywordCondition();
		keyword.setBid(100);
		keyword.setBidEquals(12);

		int n = keywordService.update(keyword);
		Assert.assertEquals(2, n);
	}

	@Test
	@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = "/pojotest/testKeyword_condition.xml")
	public void testKeywordConditionQuery() {
		KeywordCondition keywordHeadLike = new KeywordCondition();
		keywordHeadLike.setNameHeadLike("xia");
		int n = keywordService.count(keywordHeadLike);
		Assert.assertEquals(2, n);

		List<String> bidIn = new ArrayList<>();
		bidIn.add("3");
		bidIn.add("2");

		KeywordCondition keywordIn = new KeywordCondition();
		keywordIn.setBidIn(bidIn);
		n = keywordService.count(keywordHeadLike);
		Assert.assertEquals(2, n);
	}

	@Test
	@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,value ="/pojotest/testlook.xml",connection = "testDataSource" )
	public void testLook(){
         Look look=new Look();
         look.setId(1);
        int n=lookService.delete(look);
        Assert.assertEquals(1,n);
    }
    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,value ="/pojotest/testlook.xml" )
    @DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = "/pojotest/testlook1.xml")
    @ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED, value = "/pojotest/testlook1.xml")
    public void testLook2(){

        Look look=new Look();
        look.setId(3);
        look.setName("从");
        look.setSv(0);
        lookService.insert(look);


    }
}