package org.dync.teameeting.sdkmsgclient.msgs;

/**
 * Created by hp on 7/10/16.
 */
public class MSMessageManager {
    /**
     *  add message delegate
     *
     *  params:
     *      txtDelegate: the message delegate for callback to set
     *
     *  return:
     *      void
     */
    public void addDelegate(MSTxtMessageDelegate txtDelegate) {
        MsgClient.getInstance().MCSetTxtMsgDelegate(txtDelegate);
    }

    /**
     *  remove message delegate
     *
     *  params:
     *      txtDelegate: the message delegate to delete
     *
     *  return:
     *      void
     */
    public void delDelegate(MSTxtMessageDelegate txtDelegate) {
        MsgClient.getInstance().MCSetTxtMsgDelegate(null);
    }

    /**
     *  sync message when first login or refresh
     *  do not call this function in an loooooop
     *
     *  params:
     *
     *  return:
     *      void
     */
    public void syncMsg() {
        MsgClient.getInstance().MCSyncMsg();
    }

    /**
     * this will sync msg to db
     * when app will exit or crash ot leave view
     * MUST invoke this to save data
     * <p/>
     * params:
     * <p/>
     * return:
     * void
     */
    public void sync2Db() {
        MsgClient.getInstance().MCSync2Db();
    }

    /**
     *  you send message in grpId
     *
     *  params:
     *      grpId: the group id you are in
     *      content: the message you send
     *      cmsgid: the msgid of the message you send
     *      after invoke, you will get the id of this message
     *
     *  return:
     *      >0: the whole msg length
     *      -100: cmsgid is null
     *      -101: grpId or content is null
     */
    public String sendTxtMsg(String grpId, String content) {
        if (grpId.length()==0 || content.length()==0) return "";
        return MsgClient.getInstance().MCSendTxtMsg(grpId, content);
    }

    /**
     *  you send content to usres in grpId
     *
     *  params:
     *      grpId: the group id you are in
     *      users: the users you will send to in grpId
     *      content: the message you send
     *      cmsgid: the msgid of the message you send
     *      after invoke, you will get the id of this message
     *
     *  return:
     *      >0: the whole msg length
     *      -100: cmsgid is null
     *      -101: grpId or users or content is null
     */
    public String sendTxtMsgTos(String grpId, String[] userIds, String content) {
        if (grpId.length()==0 || userIds.length==0 || content.length()==0) return "";
        return MsgClient.getInstance().MCSendTxtMsgTos(grpId, userIds, content);
    }

    /**
     *  you send content to userId
     *
     *  params:
     *      usrId: the user id you will send to
     *      content: the message you send
     *      cmsgid: the msgid of the message you send
     *      after invoke, you will get the id of this message
     *
     *  return:
     *      >0: the whole msg length
     *      -100: cmsgid is null
     *      -101: usrId or content is null
     */
    public String sendTxtMsgToUser(String usrId, String content) {
        if (usrId.length()==0 || content.length()==0) return "";
        return MsgClient.getInstance().MCSendTxtMsgToUsr(usrId, content);
    }

    /**
     *  you send content to userIds
     *
     *  params:
     *      usrIds: the users ids you will send to
     *      content: the message you send
     *      cmsgid: the msgid of the message you send
     *      after invoke, you will get the id of this message
     *
     *  return:
     *      >0: the whole msg length
     *      -100: cmsgid is null
     *      -101: usrIds or content is null
     */
    public String sendTxtMsgToUsers(String[] usrIds, String content) {
        if (usrIds.length==0 || content.length()==0) return "";
        return MsgClient.getInstance().MCSendTxtMsgToUsrs(usrIds, content);
    }

    /**
     *  hostId begin to live in grpId
     *
     *  params:
     *      grpId: the group id you are in
     *      hostId: the id of the host who is living, here means yourself id
     *      flag: 1, the host begin live, 0, the host end live
     *      cmsgid: the msgid of the message you send
     *      after invoke, you will get the id of this message
     *
     *  return:
     *      >0: the whole msg length
     *      -100: cmsgid is null
     *      -101: grpId or hostId is null
     */
    public String sendNotifyLive(String grpId, String hostId, int flag) {
        if (grpId.length()==0 || hostId.length()==0) return "";
        return MsgClient.getInstance().MCNotifyLive(grpId, hostId, flag);
    }

    /**
     *  you send red-envelope to hostId in grpId
     *
     *  params:
     *      grpId: the group id you are in
     *      hostId: the id of the host you will send to
     *      cash: the cash mount you will send to host
     *      cont: the wish message you want say to host
     *      cmsgid: the msgid of the message you send
     *      after invoke, you will get the id of this message
     *
     *  return:
     *      >0: the whole msg length
     *      -100: cmsgid is null
     *      -101: grpId or hostId or cash or cont is null
     */
    public String sendNotifyRedEnvelope(String grpId, String hostId, String cash, String cont) {
        if (grpId.length()==0 || hostId.length()==0 || cash.length()==0 || cont.length()==0) return "";
        return MsgClient.getInstance().MCNotifyRedEnvelope(grpId, hostId, cash, cont);
    }

    /**
     *  userId was push to blacklist in grpId
     *
     *  params:
     *      grpId: the group id you are in
     *      userId: the user you want to pull blacklist
     *      flag: 1, set to blacklist, 0, cancel blacklist
     *      notifys: the users you want to notify, want them to know, usually group managers or group owner
     *      cmsgid: the msgid of the message you send
     *      after invoke, you will get the id of this message
     *
     *  return:
     *      >0: the whole msg length
     *      -100: cmsgid is null
     *      -101: grpId or userId or notifys is null
     */
    public String sendNotifyBlacklist(String grpId, String userId, int flag, String[] notifys) {
        if (grpId.length()==0 || userId.length()==0 || notifys.length==0) return "";
        return MsgClient.getInstance().MCNotifyBlacklist(grpId, userId, flag, notifys);
    }

    /**
     *  userId was forbidden in grpId
     *
     *  params:
     *      grpId: the group id you are in
     *      userId: the user you want to forbidden talk in this group
     *      flag: 1, forbidden user, 0, cancel forbidden
     *      notifys: the users you want to notify, want them to know, usually group managers or group owner
     *      cmsgid: the msgid of the message you send
     *      after invoke, you will get the id of this message
     *
     *  return:
     *      >0: the whole msg length
     *      -100: cmsgid is null
     *      -101: grpId or userId or notifys is null
     */
    public String sendNotifyForbidden(String grpId, String userId, int flag, String[] notifys) {
        if (grpId.length()==0 || userId.length()==0 || notifys.length==0) return "";
        return MsgClient.getInstance().MCNotifyForbidden(grpId, userId, flag, notifys);
    }

    /**
     *  userId in grpId was setted to be manager, this message will notify all members
     *
     *  params:
     *      grpId: the group id you are in
     *      userId: the user you want to set to be manager
     *      flag: 1, set user mgr, 0, set user not mgr
     *      cmsgid: the msgid of the message you send
     *      after invoke, you will get the id of this message
     *
     *  return:
     *      >0: the whole msg length
     *      -100: cmsgid is null
     *      -101: grpId or userId or notifys is null
     */
    public String sendNotifySettedMgr(String grpId, String userId, int flag) {
        if (grpId.length()==0 || userId.length()==0) return "";
        String[] notifys = {};
        return MsgClient.getInstance().MCNotifySettedMgr(grpId, userId, flag, notifys);
    }
}
