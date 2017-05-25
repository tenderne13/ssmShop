package com.ssm.user.po;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * 
 * @ClassName: Selective 
 * @Description: 选课设置
 * @author maoxian 
 * @date 2015年8月31日 上午10:38:59 
 *
 */
public class Selective implements Serializable{

	private Integer id;
	//课程id
	private Integer lesId;
	//上课性质
	private String  sceStat;
	//上课星期
	private String  sceWeek;
	//选修课上课时间
	private String ks;
	//第几节
	private String  sceLession;
	//上课地点
	private Integer clmId;
	//开始选课时间
	private Date    sceTimeXkstart;
	//结束选课时间
	private Date    sceTimeXkend;
	//选课人数
	private Integer sceNumber;
	//创建时间
	private Date    sceCreatetime;
	//创建用户
	private String  sceCreateuser;
	//年级状态(字典表)
	private String  status;
	//选课状态1:设为选课2：取消选课
	private Integer state;
	
	private Integer schoolId;
	
	private String  school;
	//开始时间
	private String  createDate;
	//结束时间
	private String  endDate;
	//学期
	private String  semester;
	//是否连课
	private String  secislk;
	//集团推送
	private Integer jtId;
	//老师ID
	private Integer teachId;
	
	private String teacherName;
	
	private Integer classId;
	//共享课程
	private Integer gxStatus;
	//设为共享
	private String  isShare;
	
	private String  lx;
	
	////////////////////////自定义///////////////////////////
	//课程数组
	private String[] asceLession;
	//是否被学生选课
    private String   ischoose;
    //选择课程的人数
    private Integer  chooseNum;
    //课程名称
    private String   lesName;
    
    
	public String getLesName() {
		return lesName;
	}
	public void setLesName(String lesName) {
		this.lesName = lesName;
	}
	public String getIschoose() {
		return ischoose;
	}
	public void setIschoose(String ischoose) {
		this.ischoose = ischoose;
	}
	public Integer getChooseNum() {
		return chooseNum;
	}
	public void setChooseNum(Integer chooseNum) {
		this.chooseNum = chooseNum;
	}
	public String[] getAsceLession() {
		return asceLession;
	}
	public void setAsceLession(String[] asceLession) {
		this.asceLession = asceLession;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLesId() {
		return lesId;
	}
	public void setLesId(Integer lesId) {
		this.lesId = lesId;
	}
	public String getKs() {
		return ks;
	}
	public void setKs(String ks) {
		this.ks = ks;
	}
	public String getSceStat() {
		return sceStat;
	}
	public void setSceStat(String sceStat) {
		this.sceStat = sceStat;
	}
	public String getSceWeek() {
		return sceWeek;
	}
	public void setSceWeek(String sceWeek) {
		this.sceWeek = sceWeek;
	}
	public String getSceLession() {
		return sceLession;
	}
	public void setSceLession(String sceLession) {
		this.sceLession = sceLession;
	}
	public Integer getClmId() {
		return clmId;
	}
	public void setClmId(Integer clmId) {
		this.clmId = clmId;
	}
	public Date getSceTimeXkstart() {
		return sceTimeXkstart;
	}
	public void setSceTimeXkstart(Date sceTimeXkstart) {
		this.sceTimeXkstart = sceTimeXkstart;
	}
	public Date getSceTimeXkend() {
		return sceTimeXkend;
	}
	public void setSceTimeXkend(Date sceTimeXkend) {
		this.sceTimeXkend = sceTimeXkend;
	}
	public Integer getSceNumber() {
		return sceNumber;
	}
	public void setSceNumber(Integer sceNumber) {
		this.sceNumber = sceNumber;
	}
	public Date getSceCreatetime() {
		return sceCreatetime;
	}
	public void setSceCreatetime(Date sceCreatetime) {
		this.sceCreatetime = sceCreatetime;
	}
	public String getSceCreateuser() {
		return sceCreateuser;
	}
	public void setSceCreateuser(String sceCreateuser) {
		this.sceCreateuser = sceCreateuser;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getSecislk() {
		return secislk;
	}
	public void setSecislk(String secislk) {
		this.secislk = secislk;
	}
	public Integer getJtId() {
		return jtId;
	}
	public void setJtId(Integer jtId) {
		this.jtId = jtId;
	}
	public Integer getTeachId() {
		return teachId;
	}
	public void setTeachId(Integer teachId) {
		this.teachId = teachId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getGxStatus() {
		return gxStatus;
	}
	public void setGxStatus(Integer gxStatus) {
		this.gxStatus = gxStatus;
	}
	public String getIsShare() {
		return isShare;
	}
	public void setIsShare(String isShare) {
		this.isShare = isShare;
	}
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	@Override
	public String toString() {
		return "Selective [id=" + id + ", lesId=" + lesId + ", sceStat="
				+ sceStat + ", sceWeek=" + sceWeek + ", ks=" + ks
				+ ", sceLession=" + sceLession + ", clmId=" + clmId
				+ ", sceTimeXkstart=" + sceTimeXkstart + ", sceTimeXkend="
				+ sceTimeXkend + ", sceNumber=" + sceNumber
				+ ", sceCreatetime=" + sceCreatetime + ", sceCreateuser="
				+ sceCreateuser + ", status=" + status + ", state=" + state
				+ ", schoolId=" + schoolId + ", school=" + school
				+ ", createDate=" + createDate + ", endDate=" + endDate
				+ ", semester=" + semester + ", secislk=" + secislk + ", jtId="
				+ jtId + ", teachId=" + teachId + ", teacherName="
				+ teacherName + ", classId=" + classId + ", gxStatus="
				+ gxStatus + ", isShare=" + isShare + ", lx=" + lx
				+ ", asceLession=" + Arrays.toString(asceLession)
				+ ", ischoose=" + ischoose + ", chooseNum=" + chooseNum
				+ ", lesName=" + lesName + "]";
	}
	
	
}
