package com.liantong.integration.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "_ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	private java.util.Collection<Plan> plan;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public java.util.Collection<Plan> getPlan() {
		if (plan == null) {
			plan = new java.util.LinkedHashSet<Plan>();
		}
		return plan;
	}

	@JSONField(serialize = false)
	public java.util.Iterator<Plan> getIteratorPlan() {
		if (plan == null) {
			plan = new java.util.LinkedHashSet<Plan>();
		}
		return plan.iterator();
	}

	public void setPlan(java.util.Collection<Plan> newCart) {
		removeAllPlan();
		for (java.util.Iterator<Plan> iter = newCart.iterator(); iter.hasNext();) {
			addPlan((Plan) iter.next());
		}
	}

	public void addPlan(Plan newPlan) {
		if (newPlan == null) {
			return;
		}
		if (this.plan == null) {
			this.plan = new java.util.LinkedHashSet<Plan>();
		}
		if (!this.plan.contains(newPlan)) {
			this.plan.add(newPlan);
			newPlan.setUser(this);
		} else {
			for (Plan temp : this.plan) {
				if (newPlan.equals(temp)) {
					if (temp != newPlan) {
						removePlan(temp);
						this.plan.add(newPlan);
						newPlan.setUser(this);
					}
					break;
				}
			}
		}
	}

	public void removePlan(Plan oldCart) {
		if (oldCart == null) {
			return;
		}
		if (this.plan != null) {
			if (this.plan.contains(oldCart)) {
				for (Plan temp : this.plan) {
					if (oldCart.equals(temp)) {
						if (temp != oldCart) {
							temp.setUser(null);
						}
						break;
					}
				}
				this.plan.remove(oldCart);
				oldCart.setUser(null);
			}
		}
	}

	public void removeAllPlan() {
		if (plan != null) {
			Plan oldPlan;
			for (java.util.Iterator<Plan> iter = getIteratorPlan(); iter.hasNext();) {
				oldPlan = (Plan) iter.next();
				iter.remove();
				oldPlan.setUser(null);
			}
			plan.clear();
		}
	}
}
