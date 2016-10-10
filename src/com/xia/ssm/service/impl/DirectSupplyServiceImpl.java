package com.xia.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.xia.base.bean.Page;
import com.xia.ssm.service.DirectSupplyService;

@Repository
public class DirectSupplyServiceImpl implements DirectSupplyService{
    
//    @Resource
//    private DirectSupplyDao directSupplyDao;
//    
//    @Override
//    public Page getCaseListPage(Page page, SupplyCaseDataVo supplyCaseDataVo) {
//        StringBuilder sql=new StringBuilder();
//        List<Object> params = new ArrayList<Object>();
//        sql.append("  SELECT i.order_no orderNo,i.id oid,i.RECEIVE_DATE completTime,p.REPORTNO reportNo,p.PLATENO plateNo, ");
//        sql.append("  i.PAY_TOTAL supplyComMoney,i.PAY_TOTAL reduceMoney,l.name companyName ");
//        sql.append("  FROM lx_order_info  i JOIN xlc_pushtask  p ON i.TASK_ID = p.ID ");
//        sql.append("  LEFT JOIN lx_aq_zz l ON p.PUSH_TARGET_ID = l.zzbh ");
//        sql.append("  WHERE i.ORDER_STATE = '4' and p.zzid = ? ");
//        params.add(supplyCaseDataVo.getZzid());
//        if(StringUtils.notEmpty(supplyCaseDataVo.getReportNo())){//报案号
//            sql.append(" AND p.reportNo = ? ");
//            params.add(supplyCaseDataVo.getReportNo());
//        }
//        if(StringUtils.notEmpty(supplyCaseDataVo.getPlateNo())){//车牌号
//            sql.append(" AND p.plateNo = ? ");
//            params.add(supplyCaseDataVo.getPlateNo());
//        }
//        if(StringUtils.notEmpty(supplyCaseDataVo.getAjLbStartDate())){//起始时间
//            sql.append(" and i.RECEIVE_DATE >= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')  ");
//            params.add(supplyCaseDataVo.getAjLbStartDate()+" 00:00:00");
//        }
//        if(StringUtils.notEmpty(supplyCaseDataVo.getAjLbEndDate())){//结束时间
//            sql.append(" and i.RECEIVE_DATE <= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')  ");
//            params.add(supplyCaseDataVo.getAjLbEndDate()+" 23:59:59");
//        }
//        page=this.directSupplyDao.findPageBySql(page, sql.toString(), params);
//        return page;
//    }
//
//    @Override
//    public Page getFactoryListPage(Page page, SupplyFactoryDataVo supplyFactoryDataVo) {
//        StringBuilder sql=new StringBuilder();
//        List<Object> params = new ArrayList<Object>();
//        sql.append("  SELECT p.PUSH_TARGET_ID xlcZzbh,l.name companyName,COUNT(i.order_no) supplyCount, SUM(i.PAY_TOTAL) supplyMoney,  ");
//        sql.append("  SUM(i.PAY_TOTAL) supplyReduceMoney,SUM(i.PAY_TOTAL) supplyAverageMoney,  ");
//        sql.append("  (COUNT(CASE WHEN o.PART_TYPE = 2 THEN o.PART_TYPE END)/COUNT(i.order_no)) brandPer  ");
//        sql.append("  FROM lx_order_info  i JOIN xlc_pushtask  p ON i.TASK_ID = p.ID  ");
//        sql.append("  LEFT JOIN lx_aq_zz l ON p.PUSH_TARGET_ID = l.zzbh ");
//        sql.append("  LEFT JOIN lx_order_part o ON i.id = o.ORDER_ID ");
//        sql.append("  WHERE i.ORDER_STATE = '4' and p.zzid = ? ");
//        params.add(supplyFactoryDataVo.getZzid());
//        if(StringUtils.notEmpty(supplyFactoryDataVo.getCompanyName())){//修理厂名称
//            sql.append(" AND  l.name like  ? ");
//            params.add("%"+supplyFactoryDataVo.getCompanyName()+"%");
//        }
//        if(StringUtils.notEmpty(supplyFactoryDataVo.getXlcReportNo())){//报案号
//            sql.append(" AND p.reportNo = ? ");
//            params.add(supplyFactoryDataVo.getXlcReportNo());
//        }
//        if(StringUtils.notEmpty(supplyFactoryDataVo.getXlcPlateNo())){//车牌号
//            sql.append(" AND p.plateNo = ? ");
//            params.add(supplyFactoryDataVo.getXlcPlateNo());
//        }
//        if(StringUtils.notEmpty(supplyFactoryDataVo.getXlcLbStartDate())){//起始时间
//            sql.append(" and i.RECEIVE_DATE >= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')  ");
//            params.add(supplyFactoryDataVo.getXlcLbStartDate()+" 00:00:00");
//        }
//        if(StringUtils.notEmpty(supplyFactoryDataVo.getXlcLbEndDate())){//结束时间
//            sql.append(" and i.RECEIVE_DATE <= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')  ");
//            params.add(supplyFactoryDataVo.getXlcLbEndDate()+" 23:59:59");
//        }
//        sql.append("  GROUP BY p.PUSH_TARGET_ID ");
//        page=this.directSupplyDao.findPageBySql(page, sql.toString(), params);
//        return page;
//    }
//
//    @Override
//    public List getCaseList(SupplyCaseDataVo supplyCaseDataVo) {
//        StringBuilder sql=new StringBuilder();
//        List<Object> params = new ArrayList<Object>();
//        sql.append("  SELECT i.order_no orderNo,i.id oid,i.RECEIVE_DATE completTime,p.REPORTNO reportNo,p.PLATENO plateNo, ");
//        sql.append("  i.PAY_TOTAL supplyComMoney,i.PAY_TOTAL reduceMoney,l.name companyName ");
//        sql.append("  FROM lx_order_info  i JOIN xlc_pushtask  p ON i.TASK_ID = p.ID ");
//        sql.append("  LEFT JOIN lx_aq_zz l ON p.PUSH_TARGET_ID = l.zzbh ");
//        sql.append("  WHERE i.ORDER_STATE = '4' and p.zzid = ? ");
//        params.add(supplyCaseDataVo.getZzid());
//        if(StringUtils.notEmpty(supplyCaseDataVo.getReportNo())){//报案号
//            sql.append(" AND p.reportNo = ? ");
//            params.add(supplyCaseDataVo.getReportNo());
//        }
//        if(StringUtils.notEmpty(supplyCaseDataVo.getPlateNo())){//车牌号
//            sql.append(" AND p.plateNo = ? ");
//            params.add(supplyCaseDataVo.getPlateNo());
//        }
//        if(StringUtils.notEmpty(supplyCaseDataVo.getAjLbStartDate())){//起始时间
//            sql.append(" and i.RECEIVE_DATE >= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')  ");
//            params.add(supplyCaseDataVo.getAjLbStartDate()+" 00:00:00");
//        }
//        if(StringUtils.notEmpty(supplyCaseDataVo.getAjLbEndDate())){//结束时间
//            sql.append(" and i.RECEIVE_DATE <= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')  ");
//            params.add(supplyCaseDataVo.getAjLbEndDate()+" 23:59:59");
//        }
//        return directSupplyDao.queryMapBySqlList(sql.toString(), params);
//    }
//
//    @Override
//    public List getFactoryList(SupplyFactoryDataVo supplyFactoryDataVo) {
//        StringBuilder sql=new StringBuilder();
//        List<Object> params = new ArrayList<Object>();
//        sql.append("  SELECT p.PUSH_TARGET_ID xlcZzbh,l.name companyName,COUNT(i.order_no) supplyCount, SUM(i.PAY_TOTAL) supplyMoney,  ");
//        sql.append("  SUM(i.PAY_TOTAL) supplyReduceMoney,SUM(i.PAY_TOTAL) supplyAverageMoney,  ");
//        sql.append("  (COUNT(CASE WHEN o.PART_TYPE = 2 THEN o.PART_TYPE END)/COUNT(i.order_no)) brandPer  ");
//        sql.append("  FROM lx_order_info  i JOIN xlc_pushtask  p ON i.TASK_ID = p.ID  ");
//        sql.append("  LEFT JOIN lx_aq_zz l ON p.PUSH_TARGET_ID = l.zzbh ");
//        sql.append("  LEFT JOIN lx_order_part o ON i.id = o.ORDER_ID ");
//        sql.append("  WHERE i.ORDER_STATE = '4' and p.zzid = ? ");
//        params.add(supplyFactoryDataVo.getZzid());
//        if(StringUtils.notEmpty(supplyFactoryDataVo.getCompanyName())){//修理厂名称
//            sql.append(" AND  l.name like  ? ");
//            params.add("%"+supplyFactoryDataVo.getCompanyName()+"%");
//        }
//        if(StringUtils.notEmpty(supplyFactoryDataVo.getXlcReportNo())){//报案号
//            sql.append(" AND p.reportNo = ? ");
//            params.add(supplyFactoryDataVo.getXlcReportNo());
//        }
//        if(StringUtils.notEmpty(supplyFactoryDataVo.getXlcPlateNo())){//车牌号
//            sql.append(" AND p.plateNo = ? ");
//            params.add(supplyFactoryDataVo.getXlcPlateNo());
//        }
//        if(StringUtils.notEmpty(supplyFactoryDataVo.getXlcLbStartDate())){//起始时间
//            sql.append(" and i.RECEIVE_DATE >= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')  ");
//            params.add(supplyFactoryDataVo.getXlcLbStartDate()+" 00:00:00");
//        }
//        if(StringUtils.notEmpty(supplyFactoryDataVo.getXlcLbEndDate())){//结束时间
//            sql.append(" and i.RECEIVE_DATE <= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')  ");
//            params.add(supplyFactoryDataVo.getXlcLbEndDate()+" 23:59:59");
//        }
//        sql.append("  GROUP BY p.PUSH_TARGET_ID ");
//        return directSupplyDao.queryMapBySqlList(sql.toString(), params);
//    }

}
