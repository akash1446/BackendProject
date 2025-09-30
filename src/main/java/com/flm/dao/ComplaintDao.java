package com.flm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flm.model.Complaint;
import com.flm.model.Resident;
import com.util.HibernateUtil;

public class ComplaintDao {
	List<Complaint> list;
	public List<Complaint> getComplaintByUser(int resId){
	   try(Session session = HibernateUtil.getConnection().openSession()){
		   list =session.createQuery("From Complaint Where userId=:resId")
				                .setParameter("resId",resId).list();
	    return list;
	   }
	   catch(Exception e) {
		   e.printStackTrace();
		   return list;
	   }
	   
	}
	public void saveComplaint(Complaint complaint) {
		Transaction ts = null;
		try(Session session = HibernateUtil.getConnection().openSession()) {
		     ts = session.beginTransaction();
		     session.persist(complaint);
		     ts.commit();
		}
		catch(Exception e) {
			if(ts.isActive() && ts!=null) {
				ts.rollback();
			}
			e.printStackTrace();
		}
		
	}
	public List<Complaint> getComplaintByUserAndStatus(int resId,String status){
		try(Session session = HibernateUtil.getConnection().openSession()){
			   list =session.createQuery("From Complaint Where userId=:resId And status=:status")
					                .setParameter("resId",resId).setParameter("status", status).list();
				 
   return list;
  }
  catch(Exception e) {
	   e.printStackTrace();
	   return list;
  }
  
}
	public Complaint getComplaintById(int complaintId) {
		 try(Session session = HibernateUtil.getConnection().openSession()){
		 Complaint complaint =session.createQuery("From Complaint Where complaintId=:complaintId",Complaint.class)
				              .setParameter("complaintId", complaintId).uniqueResult();
		    return complaint;
		   }
		   catch(Exception e) {
			   e.printStackTrace();
			   return null;
		   }
		   
		}
	public void UpdateComplaint(Complaint complaint) {
		Transaction ts = null;
		try(Session session = HibernateUtil.getConnection().openSession()) {
		     ts = session.beginTransaction();
		     session.merge(complaint);
		     ts.commit();
		}
		catch(Exception e) {
			if(ts.isActive() && ts!=null) {
				ts.rollback();
			}
			e.printStackTrace();
		}
		
			
		
	}
	public void deleteComplaint(Complaint complaint) {
		Transaction ts = null;
		try(Session session = HibernateUtil.getConnection().openSession()) {
		     ts = session.beginTransaction();
		     session.remove(complaint);
		     ts.commit();
		}
		catch(Exception e) {
			if(ts.isActive() && ts!=null) {
				ts.rollback();
			}
			e.printStackTrace();
		}
		
		
	}
	public  List<Complaint> getAllComplaints(){
		 try(Session session = HibernateUtil.getConnection().openSession()){
		List<Complaint>	list =session.createQuery("From Complaint").list();
		    return list;
		   }
		   catch(Exception e) {
			   e.printStackTrace();
			   return list;
		   }
		
	}
	public void updateStatusdao(Complaint complaint) {
		Transaction ts = null;
		try(Session session = HibernateUtil.getConnection().openSession()) {
		     ts = session.beginTransaction();
		     session.merge(complaint);
		     ts.commit();
		}
		catch(Exception e) {
			if(ts.isActive() && ts!=null) {
				ts.rollback();
			}
			e.printStackTrace();
		}

	}
}
	
    
