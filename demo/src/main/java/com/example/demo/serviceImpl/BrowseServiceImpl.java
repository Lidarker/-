package com.example.demo.serviceImpl;

import com.example.demo.bean.Browse;
import com.example.demo.bean.BrowseExample;
import com.example.demo.bean.Collect;
import com.example.demo.mapper.BrowseMapper;
import com.example.demo.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrowseServiceImpl implements BrowseService {
    @Autowired
    private BrowseMapper browseMapper;
    @Override
    public List<Browse> getAllBrowse() {
        BrowseExample browseExample=new BrowseExample();
        BrowseExample.Criteria criteria=browseExample.createCriteria();
        return browseMapper.selectByExample(browseExample);
    }

    @Override
    public List<Browse> getBrowseByRoomId(int id) {
        BrowseExample browseExample=new BrowseExample();
        BrowseExample.Criteria criteria=browseExample.createCriteria();
        criteria.andSidEqualTo(id);
        return browseMapper.selectByExample(browseExample);
    }

    @Override
    public List<Browse> getBrowseByUserId(int id) {
        BrowseExample browseExample=new BrowseExample();
        BrowseExample.Criteria criteria=browseExample.createCriteria();
        criteria.andUidEqualTo(id);
        return browseMapper.selectByExample(browseExample);
    }

    @Override
    public String insertBrowse(Browse browse) {
        int res=browseMapper.insertSelective(browse);
        if(res==1){
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public Integer deleteByRidAndUid(int rid,int uid) {
        BrowseExample browseExample=new BrowseExample();
        BrowseExample.Criteria criteria=browseExample.createCriteria();
        criteria.andSidEqualTo(rid);
        criteria.andUidEqualTo(uid);
        return browseMapper.deleteByExample(browseExample);
    }

    @Override
    public List<Browse> getBrowseByUserAndRoom(int rid, int uid) {
        BrowseExample browseExample=new BrowseExample();
        BrowseExample.Criteria criteria=browseExample.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andSidEqualTo(rid);
        return browseMapper.selectByExample(browseExample);
    }

    @Override
    public String updateBrowse(Browse browse) {
        BrowseExample browseExample=new BrowseExample();
        BrowseExample.Criteria criteria=browseExample.createCriteria();
       int res = browseMapper.updateByExample(browse,browseExample);
       if(res==1){
           return "修改成功";
       }
       return "修改失败";
    }
}
