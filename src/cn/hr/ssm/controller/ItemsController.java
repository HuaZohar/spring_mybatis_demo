package cn.hr.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.hr.ssm.po.ItemsCustom;
import cn.hr.ssm.service.ItemsService;

@Controller

//Ϊ�˶�url���з���������������ﶨ���·�������շ��ʸ�·���� ��·��+��·��
//���磺��Ʒ�б� /items/queryItems.action
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request) throws Exception{
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		List<ItemsCustom> itemsList = itemsService.findItemList(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;		
	}
	
//	@RequestMapping("/editItems")
	//����HTTP���󷽷�������post��getͬʱ֧��
//	@RequestMapping(value="/editItems",method={RequestMethod.GET,RequestMethod.POST})
//	public ModelAndView editItems() throws Exception{
//		
//		ItemsCustom itemsCustom = itemsService.findItemsById(1);
//		
//		ModelAndView modelAndView = new ModelAndView();
//		
//		modelAndView.addObject("itemsCustom",itemsCustom);
//		
//		modelAndView.setViewName("items/editItems");
//		return modelAndView;
//	}
	
	@RequestMapping(value="/editItems",method={RequestMethod.GET,RequestMethod.POST})
	//@RequestParam ���ָ��request����������ƺ��βν��а�
	//ͨ��required����ָ�������Ƿ���봫��
	//ͨ��defaultValue����ָ��Ĭ��ֵ
	public String editItems(Model model,@RequestParam(value="id",required=true) Integer items_id) throws Exception{
		
		System.out.println("@@@@@@@@@@@@@@@@@:"+ items_id);
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
		
		//�൱��modelAndView.addObject����
		model.addAttribute("itemsCustom", itemsCustom);
		
		return "items/editItems";
	}
	
	
//	@RequestMapping("/editItemsSubmit")
//	public ModelAndView editItemsSubmit() throws Exception{
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("success");
//		return modelAndView;
//	}
	
//	@RequestMapping("/editItemsSubmit")
//	public String editItemsSubmit() throws Exception{
//
//		return "redirect:queryItems.action";
//	}
	
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,Integer id,ItemsCustom itemsCustom) throws Exception{

		itemsService.updateItems(id, itemsCustom);
		return "forward:queryItems.action";
	}
	
//	@RequestMapping("/editItemsSubmit")
//	public void editItemsSubmit(HttpServletRequest request,HttpServletResponse response) throws Exception{
//		
////		request.getRequestDispatcher("queryItems.action").forward(request, response);
////		response.sendRedirect("queryItems.action");
//		
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json;charset=utf-8");
//		response.getWriter().write("{name:'zzhua',age:12}");
//	}
	
	//@RequestMapping("/itemsView/{id}")  {xxx}ռλ���������URL�����ǡ�/itemsView/1�����ߡ�/itemsView/2����
	//�����ڷ�����ʹ��@PathVariable��ȡ{xxx}�е�xxx����
	//@PathVariable���ڽ�����URL�е�ģ�����ӳ�䵽���ܴ������Ĳ�����
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id) throws Exception{
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		return itemsCustom;
	}
	
	
}
