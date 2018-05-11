package cn.edu.bupt.opensource.hrm.springboot.dao.provider;

import cn.edu.bupt.opensource.hrm.springboot.domain.pojo.Notice;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static cn.edu.bupt.opensource.hrm.springboot.common.util.contant.HrmConstants.NOTICETABLE;

/**
 * <p>Title: NoticeDynaSqlProvider</p>
 * <p>Description: 公告动态SQL语句-提供类</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-07 12:51</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class NoticeDynaSqlProvider {

    // 分页动态查询
    public String selectWhitParam(Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(NOTICETABLE);
                if(params.get("notice") != null){
                    Notice notice = (Notice)params.get("notice");
                    if(notice.getTitle() != null && !notice.getTitle().equals("")){
                        WHERE("  title LIKE CONCAT ('%',#{notice.title},'%') ");
                    }
                    if(notice.getContent() != null && !notice.getContent().equals("")){
                        WHERE("  content LIKE CONCAT ('%',#{notice.content},'%') ");
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
                FROM(NOTICETABLE);
                if(params.get("notice") != null){
                    Notice notice = (Notice)params.get("notice");
                    if(notice.getTitle() != null && !notice.getTitle().equals("")){
                        WHERE("  title LIKE CONCAT ('%',#{notice.title},'%') ");
                    }
                    if(notice.getContent() != null && !notice.getContent().equals("")){
                        WHERE("  content LIKE CONCAT ('%',#{notice.content},'%') ");
                    }
                }
            }
        }.toString();
    }

    // 动态插入
    public String insertNotice(Notice notice){
        return new SQL(){
            {
                INSERT_INTO(NOTICETABLE);
                if(notice.getTitle() != null && !notice.getTitle().equals("")){
                    VALUES("title", "#{title}");
                }
                if(notice.getContent() != null && !notice.getContent().equals("")){
                    VALUES("content", "#{content}");
                }
                if(notice.getUser() != null && notice.getUser().getId() != null){
                    VALUES("user_id", "#{user.id}");
                }
            }
        }.toString();
    }

    // 动态更新
    public String updateNotice(Notice notice){
        return new SQL(){
            {
                UPDATE(NOTICETABLE);
                if(notice.getTitle() != null && !notice.getTitle().equals("")){
                    SET(" title = #{title} ");
                }
                if(notice.getContent() != null && !notice.getContent().equals("")){
                    SET(" content = #{content} ");
                }
                if(notice.getUser() != null && notice.getUser().getId() != null){
                    SET(" user_id = #{user.id} ");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }

}