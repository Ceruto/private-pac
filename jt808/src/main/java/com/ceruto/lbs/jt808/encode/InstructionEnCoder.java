package com.ceruto.lbs.jt808.encode;

import java.util.Objects;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.message.Body;
import com.ceruto.lbs.jt808.message.Message;

/**
 * 指令生成器。 todo 需要注意的是，先设置body是不是好些？
 * 
 * @Author Ceruto
 * @Date 2019-08-12 18:27
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public class InstructionEnCoder<T extends Body> extends HeadEnCoder {
    private T body;

    public InstructionEnCoder() {
        this(InstructionConfig.normalConfig());
    }

    public InstructionEnCoder(InstructionConfig instructionConfig) {
        super(instructionConfig.getVersionIdentify(), instructionConfig.isPackage(), instructionConfig.isEncrypt(),
                instructionConfig.getVersion(), instructionConfig.getIdGenerater());
    }

    /**
     * 返回指定协议的协议解码器。
     * @param <N>
     * @param instructionConfig
     * @param clazz             指定的协议body。
     * @return
     */
    public static <N extends Body> InstructionEnCoder<N> init(InstructionConfig instructionConfig, Class<N> clazz) {
        Objects.requireNonNull(instructionConfig, "");
        InstructionEnCoder<N> instruction = new InstructionEnCoder<>(instructionConfig);
        return instruction;
    }

    /**
     * 自动创建指定的 Body 子类，并由此可以指定 Body子类的参数值。
     * 目前不成熟，先不要使用。
     * @param config    协议的基本参数配置。
     * @param clazz     Body 的子类
     * @return T 
     */
    @Deprecated
    public static <T extends Body> T initAuto(InstructionConfig config, Class<T> clazz) {
        Objects.requireNonNull(config, "");
        InstructionEnCoder<T> instruction = new InstructionEnCoder<>(config);
        T bean = null;
        try {
            bean = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        instruction.body = bean;
        return bean;
    }

    public InstructionEnCoder<T> sim(String sim){
        //todo 验证长度。
        this.getHead().setSim(sim);
        return this;
    }

    public InstructionEnCoder<T> body(T body) {
        this.body = body;
        int size = body.getBody().length;
        getHead().setMessageId(body.getMessageType().value);
        getHead().getAtrribute().setBodySize(size);
        return this;
    }

    /**
     * 自定义BODY的字节数组。
     * @param body
     * @param messageType
     * @return
     */
    public InstructionEnCoder<T> bytesBody(byte[] body, MessageType messageType){
        this.body.setBody(body);
        int size = body.length;
        getHead().setMessageId(messageType.value);
        getHead().getAtrribute().setBodySize(size);
        return this;
    }

    @Override
    public Message<T> create() {
        Message<T> message = new Message<T>(getHead());
        message.setBody(body);
        return message;
    }

}
