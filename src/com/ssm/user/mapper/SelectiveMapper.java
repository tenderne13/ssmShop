package com.ssm.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.user.po.Selective;


/**
 * 
 * @ClassName: SelectiveMapper 
 * @Description: 选课
 * @author maoxian 
 * @date 2015年8月31日 上午10:41:52 
 *
 */
public interface SelectiveMapper{
	/**
	 * 
	 * @Title: havaSelect 
	 * @Description: 是否包含
	 * @param @param lesId
	 * @param @param sceWeek
	 * @param @param semester
	 * @param @param sceLession
	 * @param @param status
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int havaSelect(@Param("lesId") Integer lesId,@Param("sceWeek")String sceWeek,
			@Param("semester")String semester,@Param("sceLession")String sceLession,
			@Param("status")String status);
	
	/**
	 * 
	 * @Title: updateState 
	 * @Description: 根据ID更改状态
	 * @param @param state
	 * @param @param id
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int updateState(@Param("id") Integer id,@Param("state") Integer state);
	
	
	/**
	 * @Title: updateShare 
	 * @Description: 更改共享状态
	 * @param @param id
	 * @param @param isShare
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int updateShare(@Param("id") Integer id,@Param("isShare") String isShare);
	
	
	/**
	 * @Title: upExpired 
	 * @Description: 更改过期
	 * @param @param id
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int upExpired();
	
	/**
	 * @Title: getListBySelective 
	 * @Description: 学生选课列表
	 * @param @param selective
	 * @param @return    设定文件 
	 * @return List<Selective>    返回类型 
	 * @throws
	 */
	List<Selective> getSelectiveBySelective(Selective selective);
	
	/**
	 * @Title: editState 
	 * @Description: 批量设置选课
	 * @param @param astrid    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void editState(String[] astrid);
	Selective getSelectLessionByPrimaryKey(Integer id);
	//根据所在班级、年级查询所能选取的课程
	List<Selective> getSelectiveOptional(@Param("grade")String grade,@Param("classs")String classs,@Param("time")String time);
	//根据选课ID查询选课结果人数
	String getChoseNum(@Param("selectiveId")int selectiveId);
	//根据选课ID查询选课信息
	Selective getSelectiveData(@Param("selectiveId")int selectiveId);
	//获取选课分组限选门数
	int getLessionLimitNum(@Param("selectiveId")int selectiveId);
	//获取学生已选课程所在分组总共选择的课程数
	int getGroupLessionNum(@Param("longinName")String longinName,@Param("selectiveId")int selectiveId);
	//更新选课开始日期截止日期
	void updateSelectiveDate(@Param("semester")int semester,@Param("createdate")String createdate,@Param("enddate")String enddate);
	//根据选课ID查询课程ID
	String getLessionNameBySelectiveId(@Param("selectiveId")int selectiveId);
	/**
	 * 根据selectiveId查询选课信息并加锁
	 */
	Selective getSelectiveBySelectiveId(@Param("selectiveId")int selectiveId);

	int updateChoseNum(@Param("sleId") Integer sleId);
	
	List<Map> getSelectiveList(@Param("grade") String grade,@Param("clasz") String clasz,@Param("timescore") String timeScore,@Param("loginname") String loginName);
}
