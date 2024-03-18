package com.iam57.nyanime.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author iam57
 * @since 2024-03-18 20:48:35
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEpisode implements Serializable {
    @Serial
    private static final long serialVersionUID = -6311921564183126416L;
    private Integer id;
    private Integer userId;
    private Integer episodeId;
    private Integer animeId;
    private LocalDateTime createTime;
}
