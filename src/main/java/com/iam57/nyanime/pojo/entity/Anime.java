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
 * @since 2024-03-18 20:39:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Anime implements Serializable {
    @Serial
    private static final long serialVersionUID = -9048312588043605938L;
    private Integer id;
    private String bangumiId;
    private String animeName;
    private String animeNameCn;
    private Byte animeType;
    private Integer episodes;
    private LocalDate date;
    private Byte week;
    private String summary;
    private String image;
}
