package taxi.model;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Car {
    private Long id;
    @NonNull
    private String model;
    @NonNull
    private Manufacturer manufacturer;
    @NonNull
    private List<Driver> drivers;
}
