package com.javaclimb.drug.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.Druginfo;
import com.javaclimb.drug.mapper.DruginfoMapper;
import org.apache.commons.lang.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.service.IDruginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class DruginfoServiceImpl extends ServiceImpl<DruginfoMapper, Druginfo> implements IDruginfoService {
    @Autowired
    private DruginfoMapper druginfoMapper;

    @Override
    public IPage<Druginfo> selectSupperPage(int pageNum, int pagesSize, String param) {
        QueryWrapper<Druginfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)){
            queryWrapper.like("name",param);
        }
        Page<Druginfo> page = new Page<>(pageNum, pagesSize);
        return  druginfoMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addDruginfo(Druginfo druginfo) {
        return druginfoMapper.insert(druginfo);
    }

    @Override
    public int editDruginfo(Druginfo druginfo) {
        return druginfoMapper.updateById(druginfo);
    }

    @Override
    public Druginfo queryDruginfoById(Integer id) {
        return druginfoMapper.selectById(id);
    }

    @Override
    public int delqueryDruginfoById(Integer id) {
        return druginfoMapper.deleteById(id);
    }

    @Override
    public List<Druginfo> queryDruginfoList() {
        return druginfoMapper.selectList(null) ;
    }
}
