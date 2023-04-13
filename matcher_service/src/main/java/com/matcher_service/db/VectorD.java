package com.matcher_service.db;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "vettoreM")
@Getter
@Setter
public class VectorD {
    @Id
    private String ad_id;
    private String owner;
    private List<String> vector_d;
    private List<String> vector_l;
    private List<String> vector_f;
    private List<String> categories;
}
