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
 * @since 2024-03-18 20:47:06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Episode implements Serializable {
    @Serial
    private static final long serialVersionUID = -7990181693748837110L;
    private Integer id;
    private Integer animeId;
    private Integer episode;
    private String summary;
    private LocalDate onAir;
}
