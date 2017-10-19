package cn.hr.ssm.service;

import java.util.List;

import cn.hr.ssm.po.ItemsCustom;
import cn.hr.ssm.po.ItemsQueryVo;

public interface ItemsService {
	
	//��Ʒ��ѯ�б�
	public List<ItemsCustom> findItemList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//����ID��ѯ��Ʒ��Ϣ  ʹ����Ʒ��Ϣ����չ��
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	
}
