package ie.dq.dao.user;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ie.dq.dao.AbstractDao;
import ie.dq.dao.UserDao;
import ie.dq.dao.model.User;
import ie.dq.dao.model.UserRole;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao implements UserDao{

	public String addUser(User user) {		
		persist(user);
		return "USER_ADDED";
	}

	public String deleteUser(User user) {	
		delete(user);
		return "USER_DELETED";
	}

	public User getByUsername(String username) {
		Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username",username));
        return (User) criteria.uniqueResult();
	}
	
	public int deleteByUsername(String username) {
		Query query = getSession().createSQLQuery("delete from web_user where username = :username");
        query.setString("username", username);
        return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
	}
	
	public String getUserPassword(String username){
		Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username",username));
        criteria.setProjection(Projections.property("password"));
        return (String) criteria.uniqueResult();
	}
	
}
