package cn.edu.bupt.opensource.hrm.springboot.dao;


import cn.edu.bupt.opensource.hrm.springboot.dao.provider.DeptDynaSqlProvider;
import cn.edu.bupt.opensource.hrm.springboot.domain.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

import static cn.edu.bupt.opensource.hrm.springboot.common.util.contant.HrmConstants.DEPTTABLE;


/**
 * <p>Title: DeptDao</p>
 * <p>Description: DeptMapper接口</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-07 12:33</p>
 * @author ChengTengfei
 * @version 1.0
 */
@Mapper
public interface DeptDao {

    // 根据ID查询部门
    @Select("select * from " + DEPTTABLE + " where ID = #{id}")
    Dept selectById(int id);

    // 根据ID删除部门
    @Delete(" delete from " + DEPTTABLE + " where id = #{id} ")
    void deleteById(Integer id);

    // 插入部门
    @SelectProvider(type=DeptDynaSqlProvider.class,method="insertDept")
    void save(Dept dept);

    // 修改部门
    @SelectProvider(type=DeptDynaSqlProvider.class,method="updateDept")
    void update(Dept dept);

    // 动态查询
    @SelectProvider(type=DeptDynaSqlProvider.class,method="selectWhitParam")
    List<Dept> selectByPage(Map<String, Object> params);

    @SelectProvider(type=DeptDynaSqlProvider.class,method="count")
    Integer count(Map<String, Object> params);

    @Select("select * from "+DEPTTABLE+" ")
    List<Dept> selectAllDept();

}