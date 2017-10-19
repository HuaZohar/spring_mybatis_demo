package cn.hr.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hr.ssm.po.ItemsCustom;

@Controller
public class JsonTestController {

	//����json�������json��
	//@RequestBody ���������Ʒ��Ϣ��jsonתΪitemsCustom����
	//@ResponseBody ��itemsCustomת��json�����
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) {
		//@ResponseBody ��itemsCustomת��json�����
		return itemsCustom;
	}
	
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom) {
		//@ResponseBody ��itemsCustomת��json�����
		return itemsCustom;
	}
	
}
