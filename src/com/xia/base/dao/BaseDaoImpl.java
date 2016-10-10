package com.xia.base.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.util.Assert;

import com.xia.base.bean.Page;
import com.xia.ssm.tools.DateTimeUtil;


public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {

    private static final String ORDERLIST = "orderList";
    private static final String CREATEDATE = "createDate";
    private static final int ASC = 0;
    private static final int DESC = 1;
    /** 返回类结束标记 */
    private static final String RETURN_CLASS_TYPE_END_WITH = "Vo";
    private static final String LIKE = "LIKE";
    private static final String AND =" AND ";
    
    private Class<T> entity;
    protected SessionFactory sessionFactory;
    
    @Resource
    HibernateTemplate hibernateTemplate;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public BaseDaoImpl() {
        Class<? extends BaseDaoImpl> class1 = this.getClass();
        Type type = class1.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type atype[] = ((ParameterizedType) type).getActualTypeArguments();
            entity = (Class<T>) atype[0];
        }
    }
    
    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    

    protected Session getSession() {
    	Session session = sessionFactory.getCurrentSession();
        return session;
    }
    

    @SuppressWarnings("unchecked")
    public T get(PK id) {
        Assert.notNull(id, "id is required");
        return (T) getSession().get(entity, id);
    }
    
    @SuppressWarnings("unchecked")
    public T load(PK id) {
        Assert.notNull(id, "id is required");
        return (T) getSession().load(entity, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> getAllList() {
        ClassMetadata classmetadata = sessionFactory.getClassMetadata(entity);
        if (ArrayUtils.contains(classmetadata.getPropertyNames(), ORDERLIST)) {
            String s = (new StringBuilder(" from ")).append(entity.getName()).append(" as entity order by entity.")
                    .append(ORDERLIST).append(" asc, entity.").append(CREATEDATE).append(" desc").toString();
            return getSession().createQuery(s).list();
        } else {
            String s1 = (new StringBuilder("from ")).append(entity.getName()).append(" as entity order by entity.")
                    .append(CREATEDATE).append(" desc").toString();
            return getSession().createQuery(s1).list();
        }
    }

    /**
     * 查询总数据
     */
    public Long getTotalCount() {
        String s = (new StringBuilder("select count(*) from ")).append(entity.getName()).toString();
        return Long.valueOf(getSession().createQuery(s).uniqueResult().toString());
    }

    @SuppressWarnings("unchecked")
    public PK save(T entity) {
        Assert.notNull(entity, "entity is required");
        Session session = getSession();
        PK pk = (PK) session.save(entity);
        session.flush();
        session.clear();
        return pk;
    }

    public void update(T entity) {
        Assert.notNull(entity, "entity is required");
        try {
            Session session = getSession();
            session.update(entity);
            session.flush();
            session.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(T entity) {
        Assert.notNull(entity, "entity is required");
        try {
            Session session = getSession();
            session.delete(entity);
            session.flush();
            session.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(PK id) {	
        Assert.notNull(id, "id is required");
        T entity = load(id);
        try {
            Session session = getSession();
            session.delete(entity);
            session.flush();
            session.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(PK ids[]) {
        Assert.notEmpty(ids, "ids must not be empty");
        for (PK id : ids) {
            T entity = load(id);
            getSession().delete(entity);
        }
    }

    public void flush() {
        getSession().flush();
    }

    public void evict(Object obj) {
        Assert.notNull(obj, "object is required");
        getSession().evict(obj);
    }

    public void clear() {
        getSession().clear();
    }

    /**
     * 分页查询（无参、无序）
     * 
     * @param page
     * @param acriterion
     */
    public Page findPage(Page page) {
        Criteria criteria = getSession().createCriteria(entity);
        return findPage(page, criteria);
    }

    /**
     * 分页查询（有集合参数、有集合排序）
     * 
     * @param page
     * @param params
     * @param orders
     */
    public Page findPage(Page page, Map<String, Object> params, Map<String, Integer> orders) {
        Criteria criteria = getSession().createCriteria(entity);
        return findPage(page, criteria, params, orders);
    }

    /**
     * 分页查询（有结构化参数）
     * 
     * @param page
     * @param acriterion
     */
    public Page findPage(Page page, Criterion acriterion[]) {
        Criteria criteria = getSession().createCriteria(entity);
        Criterion acriterion1[];
        int j = (acriterion1 = acriterion).length;
        for (int i = 0; i < j; i++) {
            Criterion criterion = acriterion1[i];
            criteria.add(criterion);
        }

        return findPage(page, criteria);
    }

    /**
     * 分页查询（默认排序）
     * 
     * @param page
     * @param orders
     */
    public Page findPage(Page page, Order orders[]) {
        Criteria criteria = getSession().createCriteria(entity);
        org.hibernate.criterion.Order orders1[];
        int j = (orders1 = orders).length;
        for (int i = 0; i < j; i++) {
            org.hibernate.criterion.Order order = orders1[i];
            criteria.addOrder(order);
        }

        return findPage(page, criteria);
    }

    /**
     * 分页查询（无参、无序）
     * 
     * @param page
     * @param criteria
     */
    public Page findPage(Page page, Criteria criteria) {
        Assert.notNull(page, "Page is required");
        Assert.notNull(criteria, "criteria is required");

        page.setRecordsTotal(getTotalCount(criteria));

        criteria.setFirstResult(page.getStart());
        criteria.setMaxResults(page.getLength());
        page.setData(criteria.list());
        return page;
    }

    /**
     * 分页查询（有集合参数、有集合排序）
     * 
     * @param page
     * @param criteria
     * @param params
     * @param orders
     * @return
     */
    public Page findPage(Page page, Criteria criteria, Map<String, Object> params, Map<String, Integer> orders) {
        Assert.notNull(page, "Page is required");
        Assert.notNull(criteria, "criteria is required");

        if (params != null) {
            // 设置参数
            for (Iterator<String> keys = params.keySet().iterator(); keys.hasNext();) {
                String key = keys.next();
                Object value = params.get(key);
                if (value instanceof String) {
                    if (key.contains(".")) {
                        String tkey = StringUtils.substringBefore(key, ".");
                        criteria.createAlias(tkey, tkey);
                    }
                    if (key.endsWith(LIKE)) {
                        key = key.substring(0, key.indexOf(LIKE));
                        criteria.add(Restrictions.like(key, (new StringBuilder("%")).append(value).append("%")
                                .toString()));
                    } else {
                        criteria.add(Restrictions.eq(key, value));
                    }
                } else if (value instanceof Integer || value instanceof Long) {
                    criteria.add(Restrictions.eq(key, value));
                } else if (value instanceof Date || value instanceof Timestamp) {
                    if (key.endsWith("Start")) {
                        key = key.substring(0, key.indexOf("Start"));
                        criteria.add(Restrictions.ge(key, value));
                    }
                    if (key.endsWith("End")) {
                        key = key.substring(0, key.indexOf("End"));
                        criteria.add(Restrictions.le(key, DateTimeUtil.addDate((Date) value, Calendar.DAY_OF_MONTH, 1)));
                    }
                } else if (value instanceof Boolean) {
                    criteria.add(Restrictions.eq(key, value));
                }
            }
        }

        if (orders != null) {
            Order o = null;
            // 设置排序
            for (Iterator<String> keys = orders.keySet().iterator(); keys.hasNext();) {
                String key = keys.next();
                int order = orders.get(key);
                if (order == ASC) {
                    o = Order.asc(key);
                } else if (order == DESC) {
                    o = Order.desc(key);
                }
                criteria.addOrder(o);
            }
        }

        page.setRecordsTotal(getTotalCount(criteria));
        criteria.setFirstResult(page.getStart());
        criteria.setMaxResults(page.getLength());
        page.setData(criteria.list());
        return page;
    }

    /**
     * 查询总记录数（结构化）
     * 
     * @param criteria
     * @return records
     */
    private long getTotalCount(Criteria criteria) {
        Assert.notNull(criteria, "criteria is required");
        long i = 0;
        CriteriaImpl criteriaimpl = (CriteriaImpl) criteria;
        Projection projection = criteriaimpl.getProjection();
        ResultTransformer resulttransformer = criteriaimpl.getResultTransformer();
        Object uniqueResult = criteriaimpl.setProjection(Projections.rowCount()).uniqueResult();
        if (uniqueResult != null) {
            i = Long.valueOf(uniqueResult.toString()).longValue();
        }
        criteriaimpl.setProjection(projection);
        if (projection == null) {
            criteriaimpl.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        }
        if (resulttransformer != null) {
            criteriaimpl.setResultTransformer(resulttransformer);
        }
        return i;
    }

    public void saveBatch(List<T> entities) {
        for (int i = 0, size = entities.size(); i < size; i++) {
            getSession().save(entities.get(i));
        }
        getSession().flush();
        getSession().clear();
    }

    /**
     * 批量跟新
     */
    public void updateBatch(List<T> entities) {
        for (int i = 0, size = entities.size(); i < size; i++) {
            getSession().update(entities.get(i));
        }

    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<T> entities) {
        for (int i = 0, size = entities.size(); i < size; i++) {
            getSession().delete(entities.get(i));
        }
    }

    /**
     * 分页查询（有集合参数、有集合排序）<T>
     * @param Page page
     * @param Map<String, Object> params
     * @param Map<String, Integer> orders
     * @return Page
     */
    public Page findPageByHql(Page page, String hql, final Map<String, Object> params,  final Map<String, String> orders) {
        // 组合SQL条件
        hql = combineSqlContitons(hql, params, orders);
        if (page.getRecordsTotal() <= 0) {
            long count = this.findCountByHql(hql, params);
            page.setRecordsTotal(count);
        }
        Query query = getSession().createQuery(hql);
        query.setFirstResult(page.getStart());
        query.setMaxResults(page.getLength());
        if (null != page.getReturnClassType()) {
            query.setResultTransformer(Transformers.aliasToBean(page.getReturnClassType()));
        }
        this.setParameters(query, params);
        page.setData(query.list());
        return page;
    }
    
    public Page findPageByHql(Page page, String hql, final List<Object> params) {
        if (page.getRecordsTotal() <= 0) {
            long count = this.findCountByHql(hql, params);
            page.setRecordsTotal(count);
        }
        Query query = getSession().createQuery(hql);
        query.setFirstResult(page.getStart());
        query.setMaxResults(page.getLength());
        if (null != page.getReturnClassType()) {
            query.setResultTransformer(Transformers.aliasToBean(page.getReturnClassType()));
        }
        this.setParameters(query, params);
        page.setData(query.list());
        return page;
    }

    public Page findPageBySql(Page page, String sql, final Map<String, Object> params,  final Map<String, String> orders) {
        // 组合SQL条件
        sql = combineSqlContitons(sql, params, orders);
        if (page.getRecordsTotal() <= 0) {
            long count = this.findCountBySql(sql, params);
            page.setRecordsTotal(count);
        }
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setFirstResult(page.getStart());
        query.setMaxResults(page.getLength());
        String returnClass = page.getReturnClass();
        if (null != page.getReturnClass()) {
            if (returnClass.endsWith(RETURN_CLASS_TYPE_END_WITH)) {
                query.setResultTransformer(Transformers.aliasToBean(page.getReturnClassType()));
            } else {
                query.addEntity(page.getReturnClassType());
            }
        }
        this.setParameters(query, params);
        page.setData(query.list());
        return page;
    }
    
    @Override
    public Page findPageBySql(Page page, String sql, final List<Object> params) {
        if (page.getRecordsTotal() <= 0) {
            long count = this.findCountBySql(sql, params);
            page.setRecordsTotal(count);
        }
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setFirstResult(page.getStart());
        query.setMaxResults(page.getLength());
        String returnClass = page.getReturnClass();
        if (null != page.getReturnClass()) {
            if (returnClass.endsWith(RETURN_CLASS_TYPE_END_WITH)) {
                query.setResultTransformer(Transformers.aliasToBean(page.getReturnClassType()));
            } else {
                query.addEntity(page.getReturnClassType());
            }
        }
        this.setParameters(query, params);
        page.setData(query.list());
        return page;
    }

    /**
     * Sql查询总条数
     */
    public Long findCountBySql(String sql, Object... values) {
        if (sql.lastIndexOf("order by") > 0) {
            sql = "select count(*) from (" + sql.substring(0, sql.lastIndexOf("order by")) + " ) as temp";
        } else {
            sql = "select count(*) from (" + sql + " ) as temp";
        }
        Query query = getSession().createSQLQuery(sql);
        this.setParameters(query, values);
        return Long.valueOf(query.uniqueResult().toString());
    }

    /**
     * Hql查询总条数
     */
    public Long findCountByHql(String hql, Object... values) {
        int beginPos = (" " + hql).toLowerCase(). indexOf(" from ");
        if (hql.lastIndexOf("order by") > 0) {
        	hql = "select count(1) " + hql.substring(beginPos, hql.lastIndexOf("order by"));
        } else {
        	hql = "select count(1) " + hql.substring(beginPos);
        }
        Query query = getSession().createQuery(hql);
        this.setParameters(query, values);
        return Long.valueOf(query.uniqueResult().toString());
    }

    @Override
    public List<?> query(Class<?> className) {
        return this.query(className, null);
    }

    @Override
    public List<?> query(Class<?> className, Map<String, Object> params) {
        return this.query(className, params, null);
    }

    @Override
    public List<?> query(Class<?> className, Map<String, Object> params, Map<String, String> orders) {
        StringBuilder hql = new StringBuilder(" from ").append(className.getName()).append(" where 1 = 1 ");
        return this.queryByHql(hql.toString(), params, orders);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<T> queryByHql(String hql, final Map<String, Object> params,  final Map<String, String> orders) {
        // 组合SQL条件
        hql = combineSqlContitons(hql, params, orders);
        Query query = getSession().createQuery(hql);
        // 设置参数
        this.setParameters(query, params);
        return query.list();
    }
    
    @Override
    public List<?> queryByHql(String hql) {
        return getSession().createQuery(hql).list();
    }
    
    @Override
    public List<?> queryByHql(String hsql, List<Object> params) {
        Query query = getSession().createQuery(hsql);
        // 设置参数
        this.setParameters(query, params);
        return query.list();
    }
    
    @Override
    public List<?> queryBySql(Class<?> className, String sql) {
        return getSession().createSQLQuery(sql).addEntity(className).list();
    }

    @Override
    public List<?> queryBySql2(Class<?> className, String sql) {
    	Session session = sessionFactory.openSession();
    	List<?> list = session.createSQLQuery(sql).addEntity(className).list();
    	session.close();
        return list;
    }
    
    @Override
    public List<?> queryBySql(Class<?> className, String sql, List<Object> params) {
        SQLQuery query = getSession().createSQLQuery(sql);
        if (className.getName().endsWith(RETURN_CLASS_TYPE_END_WITH)) {
            query.setResultTransformer(Transformers.aliasToBean(className));
        } else {
            query.addEntity(className);
        }
        // 设置参数
        this.setParameters(query, params);

        return query.list();
    }

    @Override
    public List<?> queryBySql(Class<?> className, String sql, final Map<String, Object> params,  final Map<String, String> orders) {
        // 组合SQL条件
        sql = combineSqlContitons(sql, params, orders);
        SQLQuery query = getSession().createSQLQuery(sql);
        if (className.getName().endsWith(RETURN_CLASS_TYPE_END_WITH)) {
            query.setResultTransformer(Transformers.aliasToBean(className));
        } else {
            query.addEntity(className);
        }
        // 设置参数
        this.setParameters(query, params);
        return query.list();
    }

    @Override
    public void executeBySql(String sql, Map<String, Object> params) {
        // 组合SQL条件
        sql = combineSqlContitons(sql, params, null);
        
        SQLQuery query = getSession().createSQLQuery(sql.toString());
        if (params != null && params.size() > 0) {
            for (Iterator<String> iterator = params.keySet().iterator(); iterator.hasNext();) {
                String key = iterator.next();
                Object value = params.get(key);
                query.setParameter(key.substring(key.indexOf(".") + 1, key.length()), value);
            }
        }
        query.executeUpdate();
    }
    
    @Override
    public int updateBySql(String sql, List<Object> params) {
        // 组合SQL条件
        
        SQLQuery query = getSession().createSQLQuery(sql.toString());
        if (params != null && params.size() > 0) {
        	for (int i = 0; i < params.size(); i++) {
        		if(params.get(i) instanceof byte[]){
        			query.setBinary(i, (byte[]) params.get(i));
        		}else{
        			query.setParameter(i, params.get(i));
        			
        		}
            }
        }
        return query.executeUpdate();
    }
    
    @Override
    public int updateBySql2(String sql, List<Object> params) {
        // 组合SQL条件
        Session session = sessionFactory.openSession();
        SQLQuery query = session.createSQLQuery(sql.toString());
        if (params != null && params.size() > 0) {
        	for (int i = 0; i < params.size(); i++) {
        		if(params.get(i) instanceof byte[]){
        			query.setBinary(i, (byte[]) params.get(i));
        		}else{
        			query.setParameter(i, params.get(i));
        			
        		}
            }
        }
        int i = query.executeUpdate();
        session.close();
        return i;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String,Object>> queryMapBySql(String sql, Map<String, Object> paramsMap) {
        Map<String, Object> paramsTemple = new HashMap<String, Object>();
        if (null != paramsMap) {
            paramsTemple = paramsMap;
        }
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setProperties(paramsTemple);
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String,Object>> queryMapBySqlList(String sql, List<Object> paramsMap) {
        
        
        SQLQuery query = getSession().createSQLQuery(sql);
        this.setParameters(query, paramsMap);
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String,Object>> queryMapBySql(String sql,Object params){
    	SQLQuery query = getSession().createSQLQuery(sql);
    	query.setProperties(params);
    	query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    	return query.list();
    }
    @Override
    public void executeBySqlNew(String sql, Map<String, Object> params,List<String> list) {
        SQLQuery query = getSession().createSQLQuery(sql.toString());
        if (params != null && params.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String key = list.get(i);
                Object value = params.get(key);
                query.setParameter(key,value);
            }
        }
        query.executeUpdate();
    }
    
    /**
     * 组合Sql条件
     * @param hql
     * @param params
     * @param orders
     * @return
     */
    private String combineSqlContitons(String hql, final Map<String, Object> params,  final Map<String, String> orders) {
        StringBuffer sql = new StringBuffer(hql);
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                Object value = params.get(key);
                if (value instanceof Date || value instanceof Timestamp) {
                    if (key.endsWith("Start")) {
                        String temkey = key.substring(0, key.indexOf("Start"));
                        sql.append(AND).append(temkey).append(" >= :").append(key.substring(key.indexOf(".") + 1, key.length()));
                    } else if (key.endsWith("End")) {
                        String temkey = key.substring(0, key.indexOf("End"));
                        sql.append(AND).append(temkey).append(" <= :").append(key.substring(key.indexOf(".") + 1, key.length()));
                        params.put(key, DateTimeUtil.addDate((Date) value, Calendar.DAY_OF_MONTH, 1));
                    } else {
                        sql.append(AND).append(key).append(" = :").append(key.substring(key.indexOf(".") + 1, key.length()));
                    }
                } else if (value instanceof String) {
                    // 是否模糊查询
                    if (key.endsWith(LIKE)) {
                        String temkey = key.substring(0, key.indexOf(LIKE));
                        sql.append(AND).append(temkey).append(" like :").append(key.substring(key.indexOf(".") + 1, key.length())).append("");
                        params.put(key, "%" + value.toString() + "%");
                    } else {
                        sql.append(AND).append(key).append(" = :").append(key.substring(key.indexOf(".") + 1, key.length())).append("");
                        params.put(key, value.toString());
                    }
                } else if (value instanceof Integer || value instanceof Long) {
                    sql.append(AND + key + " = :" + key.substring(key.indexOf(".") + 1, key.length()) + " ");
                } else if (value instanceof Collection) {
                    sql.append(AND + key + " in (:" + key.substring(key.indexOf(".") + 1, key.length()) + ") ");
                }
            }
        }
        if (orders != null && orders.size() > 0) {
            sql.append(" order by ");
            // 设置排序
            for (Iterator<String> keys = orders.keySet().iterator(); keys.hasNext();) {
                String key = keys.next();
                String order = orders.get(key);
                sql.append(key).append(" ").append(order).append(",");
            }
            sql.delete(sql.length() - 1, sql.length());
        }
        return sql.toString();
    }
    
    /**
     * 设置查询参数
     */
    @SuppressWarnings("unchecked")
    private void setParameters(Query query, Object... values) {
        if (values != null) {
            if (values.length == 1 && values[0] != null) {
            	if(values[0] instanceof Map) {
	                Map<String, ?> valueMap = (Map<String, ?>) values[0];
	                for (Iterator<String> iterator = valueMap.keySet().iterator(); iterator.hasNext();) {
	                    String key = iterator.next();
	                    Object value = valueMap.get(key);
	                    if (value == null) {
	                        continue;
	                    }
	                    if (value instanceof Collection) {
	                        query.setParameterList(key.substring(key.indexOf(".") + 1, key.length()), (Collection<?>) value);
	                    } else {
	                        query.setParameter(key.substring(key.indexOf(".") + 1, key.length()), value);
	                    }
	                }
            	} else if(values[0] instanceof List) {
            		List<Object> valueList = (List<Object>) values[0];
            		for (int i = 0; i < valueList.size(); i++) {
                        query.setParameter(i, valueList.get(i));
                    }
            	}
            } else {
                for (int i = 0; i < values.length; i++) {
                	if (values[0] != null) {
                		query.setParameter(i, values[i]);
                	}
                }
            }
        }
    }
}
