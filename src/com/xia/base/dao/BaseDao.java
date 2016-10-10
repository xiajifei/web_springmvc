package com.xia.base.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.xia.base.bean.Page;

/**
 * Description:基础dao操作接口类。
 * 
 * @param <T>
 * @param <PK>
 * 
 */
public interface BaseDao<T, PK extends Serializable> {

    /**
     * 根据主键取得<T>
     * @param PK id
     * @return T
     */
    public abstract T get(PK id);
    
    /**
     * 根据主键取得<T>
     * @param PK id
     * @return T
     */
    public abstract T load(PK id);
    
    /**
     * 保存<T>
     * @param T entity
     * @return 主键
     */
    public abstract PK save(T entity);
    
    /**
     * 批量保存<T>
     * @param List<T> entities
     */
    public abstract void saveBatch(List<T> entities);
    
    /**
     * 更新<T>
     * @param T entity
     */
    public abstract void update(T entity);
    
    /**
     * 批量更新<T>
     * @param List<T> entities
     */
    public abstract void updateBatch(List<T> entities);
    
    /**
     * 删除<T>
     * @param T entity
     */
    public abstract void delete(T entity);
    
    /**
     * 根据主键删除<T>
     * @param PK id
     */
    public abstract void delete(PK id);
    
    /**
     * 根据主键批量删除<T>
     * @param PK[]
     */
    public abstract void delete(PK[] ids);
    
    /**
     * 批量删除<T>
     * @param List<T> entities
     */
    public abstract void deleteBatch(List<T> entities);
    
    /**
     * 强制与数据库同步<T>
     */
    public abstract void flush();
    
    /**
     * 清除对象缓存
     * @param Object obj
     */
    public abstract void evict(Object obj);
    
    /**
     * 清除全部对象缓存
     */
    public abstract void clear();
    
    /**
     * 取得全部记录<T>
     * @return List<T>
     */
    public abstract List<T> getAllList();
    
    /**
     * 分页查询<T>
     * @param Page page
     * @return Page
     */
    public abstract Page findPage(Page page);
    
    /**
     * 分页查询（有结构化参数）<T>
     * @param Page page
     * @param Criterion[] acriterions
     * @return Page
     */
    public abstract Page findPage(Page page, Criterion[] criterions);
    
    /**
     * 分页查询（有排序）<T>
     * @param Page page
     * @param Order[] orders
     * @return Page
     */
    public abstract Page findPage(Page page, Order[] orders);
    
    /**
     * 分页查询（有集合参数、有集合排序）<T>
     * @param Page page
     * @param Map<String, Object> params
     * @param Map<String, Integer> orders
     * @return Page
     */
    public abstract Page findPage(Page page, Map<String, Object> params, Map<String, Integer> orders);
    
    /**
     * HQL分页查询，动态组合查询条件、设置参数
     * @param Page page
     * @param hql
     * @param Map<String, Object> params
     * @param Map<String, String> orders
     * @return Page
     */
    public abstract Page findPageByHql(Page page, String hql, final Map<String, Object> params,  final Map<String, String> orders);
    
    /**
     * HQL分页查询,动态设置参数
     * 如果Page.returnClass为空，返回集合是sql默认entity；反之，如果想返回集合是自定义Vo，需设置Page.returnClass以“Vo”结尾，其他返回实体类集合。
     * @param Page page
     * @param String hql
     * @param List<Object> params
     * @return Page
     */
    public Page findPageByHql(Page page, String hql, final List<Object> params);
    
    /**
     * SQL分页查询，动态组合查询条件、设置参数
     * 如果Page.returnClass为空，返回集合是sql默认entity；反之，如果想返回集合是自定义Vo，需设置Page.returnClass以“Vo”结尾，其他返回实体类集合。
     * @param Page page
     * @param String sql
     * @param Map<String, Object> params
     * @param Map<String, String> orders
     * @return Page
     */
    public abstract Page findPageBySql(Page page, String sql, final Map<String, Object> params, final Map<String, String> orders);
    
    /**
     * SQL分页查询，动态设置参数
     * 如果Page.returnClass为空，返回集合是sql默认entity；反之，如果想返回集合是自定义Vo，需设置Page.returnClass以“Vo”结尾，其他返回实体类集合。
     * @param Page page
     * @param String sql
     * @param List<Object> params
     * @return Page
     */
    public Page findPageBySql(Page page, String sql, final List<Object> params);
    
    
    /**
     * HQL记录数查询
     * @param String hql
     * @param Object... values
     * @return Page
     */
    public abstract Long findCountByHql(String hql, Object... values);
    
    /**
     * SQL记录数查询
     * @param String sql
     * @param Object... values
     * @return Page
     */
    public abstract Long findCountBySql(String sql, Object... values);
    
    /**
     * HQL查询
     * @param String hql
     * @return List<?>
     */
    public abstract List<?> queryByHql(String hql);
    
    /**
     * HQL查询，动态设置参数
     * 此查询方式，允许hql可包含以“?”为占位符的检索条件。
     * @param String hql
     * @param List<Object> params
     * @return List<?>
     */
    public abstract List<?> queryByHql(String hql, List<Object> params);
    
    /**
     * HQL查询，动态组合查询条件、设置参数
     * 此查询方式，允许hql可包含以用“：+ 命名”为占位符的检索条件。
     * @param String hql
     * @param Map<String, Object> params
     * @param Map<String, String> orders
     * @return List<?>
     */
    public abstract List<?> queryByHql(String hql, final Map<String, Object> params,  final Map<String, String> orders);
    
    /**
     * SQL查询
     * @param Class<?> className
     * @param String sql
     * @return List<T>
     */
    public abstract List<?> queryBySql(Class<?> className, String sql);
    
    /**
     * SQL查询
     * @param Class<?> className
     * @param String sql
     * @return List<T>
     */
    public abstract List<?> queryBySql2(Class<?> className, String sql);
    
    /**
     * SQL查询，动态设置参数
     * 此查询方式，允许sql可包含以“?”为占位符的检索条件，返回类名为className的元素集合。
     * @param Class<?> className
     * @param String sql
     * @param List<Object> params
     * @return List<?>
     */
    public abstract List<?> queryBySql(Class<?> className, String sql, List<Object> params);

    /**
     * SQL执行
     * 此查询方式，允许sql可包含以用“：+ 命名”为占位符的检索条件。返回map元素的集合。
     * @param String sql
     * @param Map<String, Object> params
     * @return List<Map<?, ?>>
     */
    public abstract List<Map<String,Object>> queryMapBySql(String sql, Map<String, Object> paramsMap);
    /**
     * SQL执行
     * 此查询方式，允许sql可包含以用“：+ 命名”为占位符的检索条件
     * @param String sql
     * @param list
     * @return List<Map<?, ?>>
     */
    public abstract List<Map<String,Object>> queryMapBySql(String sql,Object params);
	public abstract List<Map<String,Object>> queryMapBySqlList(String sql, List<Object> paramsMap);

    /**
     * SQL查询，动态组合查询条件、设置参数
     * 此查询方式，允许sql可包含以用“：+ 命名”为占位符的检索条件，返回类名为className的元素集合
     * @param Class<?> className
     * @param String sql
     * @param Map<String, Object> params
     * @param Map<String, String> orders
     * @return List<?>
     */
    public abstract List<?> queryBySql(Class<?> className, String sql, final Map<String, Object> params, final Map<String, String> orders);
    
    /**
     * 根据类名查询（无参、无序）
     * @param className
     * @return List<?>
     */
    public abstract List<?> query(Class<?> className);
    
    /**
     * 根据类名查询（有参），动态组合查询条件、设置参数
     * @param className
     * @param params
     * @return
     */
    public abstract List<?> query(Class<?> className, final Map<String, Object> params);
    
    /**
     * 根据类名查询（有参、有序），动态组合查询条件、设置参数
     * @param className
     * @param params
     * @param orders
     * @return
     */
    public abstract List<?> query(Class<?> className, final Map<String, Object> params, final Map<String, String> orders);
    
    /**
     * SQL执行
     * 允许sql包含“：+ 命名”的占位符
     * @param String sql
     * @param Map<String, Object> params
     */
    public abstract void executeBySql(String sql, Map<String, Object> params);

    /**
     * SQL执行
     * 允许sql包含“：+ 命名”的占位符
     * list key的顺序
     * @param String sql
     * @param Map<String, Object> params
     */
	void executeBySqlNew(String sql, Map<String, Object> params, List<String> list);
	
	public int updateBySql(String sql, List<Object> params);
	
	public int updateBySql2(String sql, List<Object> params);
}
