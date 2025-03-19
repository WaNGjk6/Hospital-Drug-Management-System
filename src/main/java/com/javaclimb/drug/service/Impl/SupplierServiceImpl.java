package com.javaclimb.drug.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.mapper.SupplierMapper;
import com.javaclimb.drug.service.ISupplierService;
import org.apache.commons.lang.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;




/**
 * @author admin
 * @version 1.0.0
 * @ClassName IuserServiceImpl.java
 * @Description TODO  供应商的service实现类
 * @createTime 2024年09月02日 11:51:00
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {
    @Autowired
    private SupplierMapper supplierMapper;
    /**
     *分页查询供应商数据
     * @param pageNum  第几页
     * @param pagesSize 每页有多少条数据
     * @param param  查询参数
     * @return
     */
    @Override
    public IPage<Supplier> selectSupperPage(int pageNum, int pagesSize, String param) {
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)){
            queryWrapper.like("name",param);
        }
        Page<Supplier> page = new Page<>(pageNum, pagesSize);
        return  supplierMapper.selectPage(page,queryWrapper);
    }
    /**
     * 新增一条供应信息
     * @param supplier
     */
    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }
    /**
     * 修改一条供应信息
     * @param supplier
     */
    @Override
    public int editSupplier(Supplier supplier) {
        return supplierMapper.updateById(supplier);
    }
    /**
     * 根据主键id查询一条供应商对象
     * @param id
     * @return
     */
    @Override
    public Supplier querySupplierById(Integer id) {
        return supplierMapper.selectById(id);
    }
    /**
     * 根据主键id删除一条供应商对象
     * @param id
     * @return
     */
    @Override
    public int delquerySupplierById(Integer id) {
        return supplierMapper.deleteById(id);
    }
    /**
     * 查询所有供应商
     * @return
     */
    @Override
    public List<Supplier> querySupplierList() {
        return supplierMapper.selectList(null) ;
    }
}
