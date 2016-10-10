package com.xia.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xia.base.bean.Page;
import com.xia.ssm.service.DirectSupplyService;
import com.xia.ssm.tools.ExcelExportTool;

import jxl.Workbook;
import jxl.write.WritableWorkbook;
@Controller
@RequestMapping("/supply")
public class DirectSupplyController {
//    @Autowired
//    private DirectSupplyService directSupplyService;
//    @Autowired
//    LxAqZzService lxAqZzService;
//
//	@RequestMapping("/directSupply")
//	public ModelAndView directSupply(HttpServletRequest request){
//		return new ModelAndView("supply/direct-supply");
//	}
//	
//	/**
//	 * 获取案件列表
//	 * @param page
//	 * @param supplyCaseDataVo
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value = "/getCaseListPage")
//    @ResponseBody
//    public Page getCaseListPage(Page page, SupplyCaseDataVo supplyCaseDataVo, HttpServletRequest request,
//            HttpServletResponse response) {
//        UserDetail userInfo = (UserDetail) request.getSession().getAttribute("UserInfos");
//        supplyCaseDataVo.setZzid(userInfo.getZzid());
//        page.setReturnClass(SupplyCaseDataVo.class);
//        page = directSupplyService.getCaseListPage(page, supplyCaseDataVo);
//        return page;
//    }
//	
//	/**
//	 * 获取修理厂列表
//	 * @param page
//	 * @param supplyFactoryDataVo
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value = "/getFactoryListPage")
//    @ResponseBody
//    public Page getFactoryListPage(Page page, SupplyFactoryDataVo supplyFactoryDataVo, HttpServletRequest request,
//            HttpServletResponse response) {
//        UserDetail userInfo = (UserDetail) request.getSession().getAttribute("UserInfos");
//        supplyFactoryDataVo.setZzid(userInfo.getZzid());
//        page.setReturnClass(SupplyFactoryDataVo.class);
//        page = directSupplyService.getFactoryListPage(page, supplyFactoryDataVo);
//        return page;
//    }
//	
//	/**
//	 * 导出案件列表信息
//	 * @param organReportVo
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value="/exportAjData")
//    public void exportAjData(SupplyCaseDataVo supplyCaseDataVo,HttpServletRequest request,HttpServletResponse response) {
//        UserDetail userInfo = (UserDetail) request.getSession().getAttribute("UserInfos");
//        String cstjFlag=request.getParameter("cstjFlag");
//        supplyCaseDataVo.setZzid(userInfo.getZzid());
//        String filename = "";
//        List list= directSupplyService.getCaseList(supplyCaseDataVo);
//        List<SupplyCaseDataVo> li = new ArrayList<SupplyCaseDataVo>();
//        if(list!=null&&list.size()>0){
//            for(int i=0;i<list.size();i++){
//                
//                HashMap<String, Object> map = (HashMap<String, Object>) list.get(i);
//                SupplyCaseDataVo vv = new SupplyCaseDataVo();
//                vv.setCompletTime(map.get("completTime")==null?"":map.get("completTime").toString());
//                vv.setReportNo(map.get("reportNo")==null?"":map.get("reportNo").toString());
//                vv.setPlateNo(map.get("plateNo")==null?"":map.get("plateNo").toString());
//                vv.setSupplyComMoney(map.get("supplyComMoney")==null?"":map.get("supplyComMoney").toString());
//                vv.setReduceMoney(map.get("reduceMoney")==null?"":map.get("reduceMoney").toString());
//                vv.setCompanyName(map.get("companyName")==null?"":map.get("companyName").toString());
//                li.add(vv);
//            }
//        }
//      //设置文件类型
//        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-disposition", "attachment;filename="+ExcelExportTool.toUtf8String(filename)+TimestampTool.getStringDateNew()+".xls");
//        WritableWorkbook wwb;
//        try {
//            wwb = Workbook.createWorkbook(response.getOutputStream());
//            String[] titleArray = new String[]{"完成日期","报案号","车牌号","直供完成金额","减损金额","修理厂名称"};
//            String[] columnArray = new String[]{"completTime","reportNo","plateNo","supplyComMoney","reduceMoney","companyName"};
//            
//            //导出Excel
//            ExcelExportTool.exportExcelWithJXL(wwb, filename, titleArray, columnArray, li);
//            
//            wwb.write();
//            wwb.close();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            System.out.println("导出Excel失败!");
//        } 
//	}   
}
