package cn.edu.bupt.opensource.hrm.springboot.dao.provider;

import cn.edu.bupt.opensource.hrm.springboot.domain.pojo.Job;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static cn.edu.bupt.opensource.hrm.springboot.common.util.contant.HrmConstants.JOBTABLE;

/**
 * <p>Title: JobDynaSqlProvider</p>
 * <p>Description: 职位动态SQL语句-提供类</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-07 12:50</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class JobDynaSqlProvider {

    // 分页动态查询
    public String selectWhitParam(Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(JOBTABLE);
                if(params.get("job") != null){
                    Job job = (Job) params.get("job");
                    if(job.getName() != null && !job.getName().equals("")){
                        WHERE("  name LIKE CONCAT ('%',#{job.name},'%') ");
                    }
                }
            }
        }.toString();
        if(params.get("pageModel") != null){
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
        }
        return sql;
    }

    // 动态查询总数量
    public String count(Map<String, Object> params){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(JOBTABLE);
                if(params.get("job") != null){
                    Job job = (Job) params.get("job");
                    if(job.getName() != null && !job.getName().equals("")){
                        WHERE("  name LIKE CONCAT ('%',#{job.name},'%') ");
                    }
                }
            }
        }.toString();
    }

    // 动态插入
    public String insertJob(Job job){
        return new SQL(){
            {
                INSERT_INTO(JOBTABLE);
                if(job.getName() != null && !job.getName().equals("")){
                    VALUES("name", "#{name}");
                }
                if(job.getRemark() != null && !job.getRemark().equals("")){
                    VALUES("remark", "#{remark}");
                }
            }
        }.toString();
    }

    // 动态更新
    public String updateJob(Job job){
        return new SQL(){
            {
                UPDATE(JOBTABLE);
                if(job.getName() != null){
                    SET(" name = #{name} ");
                }
                if(job.getRemark() != null){
                    SET(" remark = #{remark} ");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }

}