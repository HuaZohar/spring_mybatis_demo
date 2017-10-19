package cn.hr.ssm.service.impl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.codehaus.jackson.map.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;

import cn.hr.ssm.mapper.ItemsMapper;
import cn.hr.ssm.mapper.ItemsMapperCustom;
import cn.hr.ssm.po.Items;
import cn.hr.ssm.po.ItemsCustom;
import cn.hr.ssm.po.ItemsQueryVo;
import cn.hr.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService{

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemList(ItemsQueryVo itemsQueryVo) throws Exception {
		return itemsMapperCustom.findItemList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		
		Items items = itemsMapper.selectByPrimaryKey(id);
		
		ItemsCustom itemsCustom = new ItemsCustom();
		
		//��һ������ Ŀ�Ķ���   �ڶ����� Դ����
		BeanUtils.copyProperties(itemsCustom,items ); //?????  ������������չ������
		
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception {
		
		//������Ʒ��Ϣʹ��updateByPrimaryKeyWithBLOBs����ID����items���������ֶΣ��������ı�����
		//updateByPrimaryKeyWithBLOBs ���봫��ID
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}
	
}
