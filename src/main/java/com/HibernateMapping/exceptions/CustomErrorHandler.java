package com.HibernateMapping.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorHandler {
   private Date timeStamp;
   private String Message;
   private String errorDetails;

}
