package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Problem;

public interface IProblemService extends IService<Problem> {

    public IPage<Problem> selectProblemPage(int pageNum, int pageSize, String param);


    public int addProblem(Problem problem);


    public int editProblem(Problem problem);


    public Problem queryProblemById(Integer id);


    public int delProblemById(Integer id);

}
