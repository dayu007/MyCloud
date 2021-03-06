package common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseMsginfo<M extends BaseMsginfo<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public M setChatroom(java.lang.String chatroom) {
		set("chatroom", chatroom);
		return (M)this;
	}
	
	public java.lang.String getChatroom() {
		return getStr("chatroom");
	}

	public M setMsgfrom(java.lang.String msgfrom) {
		set("msgfrom", msgfrom);
		return (M)this;
	}
	
	public java.lang.String getMsgfrom() {
		return getStr("msgfrom");
	}

	public M setMsgto(java.lang.String msgto) {
		set("msgto", msgto);
		return (M)this;
	}
	
	public java.lang.String getMsgto() {
		return getStr("msgto");
	}

	public M setChattime(java.util.Date chattime) {
		set("chattime", chattime);
		return (M)this;
	}
	
	public java.util.Date getChattime() {
		return get("chattime");
	}

	public M setChataction(java.lang.String chataction) {
		set("chataction", chataction);
		return (M)this;
	}
	
	public java.lang.String getChataction() {
		return getStr("chataction");
	}

	public M setMsgcontent(java.lang.String msgcontent) {
		set("msgcontent", msgcontent);
		return (M)this;
	}
	
	public java.lang.String getMsgcontent() {
		return getStr("msgcontent");
	}

	public M setSecret(java.lang.Boolean secret) {
		set("secret", secret);
		return (M)this;
	}
	
	public java.lang.Boolean getSecret() {
		return get("secret");
	}

}
