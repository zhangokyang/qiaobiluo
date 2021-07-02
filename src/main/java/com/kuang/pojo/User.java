package com.kuang.pojo;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

  private Integer id;
  private String userName;
  private String pwd;

}
