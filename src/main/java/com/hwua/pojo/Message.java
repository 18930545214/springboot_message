package com.hwua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

  private Long id;
  private Long sendId;
  private String title;
  private String msgContent;
  private Integer state;
  private Long receiveId;
  private String msg_Create_Date;
  private User sendUser;// 短消息和发送者是1对1的关系

}
