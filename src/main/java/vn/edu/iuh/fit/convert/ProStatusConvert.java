package vn.edu.iuh.fit.convert;

import vn.edu.iuh.fit.enums.ProductStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ProStatusConvert implements AttributeConverter<ProductStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProductStatus productStatus) {
        if (productStatus == null) {
            return null;
        }
        return productStatus.getValue();
    }

    @Override
    public ProductStatus convertToEntityAttribute(Integer integer) {
        if (integer == 1) {
            return ProductStatus.ACTIVE;
        } else if (integer == 0) {
            return ProductStatus.IN_ACTIVE;
        } else if (integer == -1) {
            return ProductStatus.TERMINATED;
        } else {
            return ProductStatus.ACTIVE; // Default to ACTIVE for unknown values
        }
    }
}
