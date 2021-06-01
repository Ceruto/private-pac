package com.ceruto.lbs.jt808.message.body;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.message.Body;

public class LagPackageReqeustBody extends Body {

    public LagPackageReqeustBody() {
        super(MessageType.CLIENT_SIDE_GET_LAG_PACKAGE);
    }

    // 原始序列号
    int serialId;
   //需要重传的包的总数
    int packageSize;
    //包id列表
    int[] ids;

    public void setSerialId(int serialId) {
        this.serialId = serialId;
    }
    public int getSerialId() {
        return serialId;
    }

    public void setPackageSize(int packageSize) {
        this.packageSize = packageSize;
    }
    public int getPackageSize() {
        return packageSize;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }
    public int[] getIds() {
        return ids;
    }

	@Override
	public byte[] toBytes() {
		return null;
	}
}
