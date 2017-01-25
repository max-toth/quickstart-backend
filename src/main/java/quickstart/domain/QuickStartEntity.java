package quickstart.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author mtolstyh
 * @since 25.01.2017.
 */
@Document
public class QuickStartEntity {
    @Id
    public String id;

    public Object data;
}
