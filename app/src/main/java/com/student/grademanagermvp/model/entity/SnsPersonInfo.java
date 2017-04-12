package com.student.grademanagermvp.model.entity;

import android.text.TextUtils;

import java.util.List;

public class SnsPersonInfo {
	private String account;//账户  暂无
	private String password;
	private int usertype;
	private int signinState;//签到状态     暂无
	private long signinTime;//签到时间    暂无
	
	private String nickname="";
	private String signature="";
	private String avatar_s="";
	private String avatar_m="";
	private String avatar_l="";
	private String iconurl = "";
	public String totalscore="";//等级积分
    private String userid;
    private String attention;
    private String fans;
    private String gradeid;//等级
    private String vip;//等级字段
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	/** 性别 */
	private int gender = GENDER_SECRECY;
	public static final int GENDER_GIRL = 0;
	public static final int GENDER_BOY = 1;
	public static final int GENDER_SECRECY = 2;
	/** 职业 */
	private String career = "";
	/** 生日 */
	private String birthday = "";
	/** 血型 */
	private String bloodtype = "";
	/** 书籍标签 */
	private List<String> likebookmark;
	/** 联系方式 - QQ号码(不作为用户识别信息) */
	private String qqnum = "";
	/** 联系方式 - 手机(不作为用户识别信息) */
	private String mobile = "";
	/** 联系方式 - 邮箱 (不作为用户识别信息) */
	private String email = "";
	/** 偏好分类 */
	private String likecatalog = "";
	/**标示是不是自定义图像
	 * 1  已经自定义头像  0 未自定义头像
	 * */
	private int replacepicflag;
	/** 通讯地址 **/
	private String address;
	private String linkMan;
	private String phoneNumber;
	private String province;
	private String city;
	private String county;
	private String detailAddress;

	private int zsYd;//首次完善资料赠送阅点(有的话大于0，没有为0)

	public int getZsYd() {
		return zsYd;
	}

	public void setZsYd(int zsYd) {
		this.zsYd = zsYd;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAvatar_s() {
		return avatar_s;
	}
	public void setAvatar_s(String avatar_s) {
		this.avatar_s = avatar_s;
	}
	public String getAvatar_l() {
		return avatar_l;
	}
	public void setAvatar_l(String avatar_l) {
		this.avatar_l = avatar_l;
	}
	public String getAvatar_m() {
		return avatar_m;
	}
	public void setAvatar_m(String avatar_m) {
		this.avatar_m = avatar_m;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}	
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getTotalscore() {
	    if(TextUtils.isEmpty(totalscore))
	    {
	        totalscore = "0";
	    }
		return totalscore;
	}
	public void setTotalscore(String totalscores) {
		this.totalscore = totalscores;
	}
    public String getUserid()
    {
        return userid;
    }
    public void setUserid(String userid)
    {
        this.userid = userid;
    }
    public String getAttention()
    {
        return attention;
    }
    public void setAttention(String attention)
    {
        this.attention = attention;
    }
    public String getFans()
    {
        return fans;
    }
    public void setFans(String fans)
    {
        this.fans = fans;
    }
    public String getGradeid()
    {
        return gradeid;
    }
    public void setGradeid(String gradeid)
    {
        this.gradeid = gradeid;
    }
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBloodtype() {
		return bloodtype;
	}
	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}
	public List<String> getLikebookmark() {
		return likebookmark;
	}
	public void setLikebookmark(List<String> likebookmark) {
		this.likebookmark = likebookmark;
	}
	public String getQqnum() {
		return qqnum;
	}
	public void setQqnum(String qqnum) {
		this.qqnum = qqnum;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLikecatalog() {
		return likecatalog;
	}
	public void setLikecatalog(String likecatalog) {
		this.likecatalog = likecatalog;
	}
	public String getIconurl() {
		return iconurl;
	}
	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}
	public int getReplacepicflag() {
		return replacepicflag;
	}
	public void setReplacepicflag(int replacepicflag) {
		this.replacepicflag = replacepicflag;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public int getSigninState() {
		return signinState;
	}
	public void setSigninState(int signinState) {
		this.signinState = signinState;
	}
	public long getSigninTime() {
		return signinTime;
	}
	public void setSigninTime(long signinTime) {
		this.signinTime = signinTime;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	
	
}
