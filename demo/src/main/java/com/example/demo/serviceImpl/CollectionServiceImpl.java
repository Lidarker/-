package com.example.demo.serviceImpl;

import com.example.demo.bean.Collect;
import com.example.demo.bean.CollectExample;
import com.example.demo.bean.User;
import com.example.demo.mapper.CollectMapper;
import com.example.demo.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectMapper collectMapper;
    @Override
    public List<Collect> getAllCollection() {
        CollectExample collectExample=new CollectExample();
        CollectExample.Criteria criteria=collectExample.createCriteria();
        return collectMapper.selectByExample(collectExample);
    }

    @Override
    public List<Collect> getCollectionByRoomId(int id) {
        CollectExample collectExample=new CollectExample();
        CollectExample.Criteria criteria=collectExample.createCriteria();
        criteria.andRidEqualTo(id);
        return collectMapper.selectByExample(collectExample);
    }

    @Override
    public List<Collect> getCollectionByUserId(int id) {
        CollectExample collectExample=new CollectExample();
        CollectExample.Criteria criteria=collectExample.createCriteria();
        criteria.andUidEqualTo(id);
        return collectMapper.selectByExample(collectExample);
    }

    @Override
    public List<Collect> getCollectionByCId(int id) {
        CollectExample collectExample=new CollectExample();
        CollectExample.Criteria criteria=collectExample.createCriteria();
        criteria.andCidEqualTo(id);
        return collectMapper.selectByExample(collectExample);
    }

    @Override
    public String insertCollection(Collect collect) {
        int res=collectMapper.insertSelective(collect);
        if(res==1) return "插入成功";
        return "插入失败";
    }

    @Override
    public Integer deleteByRid(int rid) {
        CollectExample collectExample=new CollectExample();
        CollectExample.Criteria criteria=collectExample.createCriteria();
        criteria.andRidEqualTo(rid);
        return collectMapper.deleteByExample(collectExample);
    }


}
