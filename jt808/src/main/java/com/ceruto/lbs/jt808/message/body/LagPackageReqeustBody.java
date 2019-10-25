package com.ceruto.lbs.jt808.message.body;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.message.Body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
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

	@Override
	public byte[] toBytes() {
		return null;
	}
}
