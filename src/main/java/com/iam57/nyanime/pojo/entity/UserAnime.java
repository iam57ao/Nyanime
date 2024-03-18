package com.iam57.nyanime.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author iam57
 * @since 2024-03-18 20:44:57
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAnime implements Serializable {
    @Serial
    private static final long serialVersionUID = -6014543472461638853L;
    private Integer id;
    private Integer userId;
    private Integer animeId;
    private Byte status;
    private LocalDate createTime;
    private LocalDate updateTime;
}
