package ie.dq.dao.user;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ie.dq.dao.AbstractDao;
import ie.dq.dao.UserRoleDao;
import ie.dq.dao.model.UserRole;

@Repository("userRoleDao")
@Transactional
public class UserRoleDaoImpl extends AbstractDao implements UserRoleDao{

	public void addUserRole(UserRole userRole) {
		persist(userRole);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getUserAuthorities(String username) {
		Criteria criteria = getSession().createCriteria(UserRole.class);
        criteria.add(Restrictions.eq("username",username));
        criteria.setProjection(Projections.property("role"));
        return criteria.list();
	}

}
