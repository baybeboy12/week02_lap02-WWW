package vn.edu.iuh.fit.convert;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.enums.EmployeeStatus;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class EmpStatusConvert implements AttributeConverter<EmployeeStatus,Integer> {

    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus employeeStatus) {
        if (employeeStatus == null) {
            return null;
        }
        return employeeStatus.getValue();
    }

    @Override
    public EmployeeStatus convertToEntityAttribute(Integer integer) {
        if (integer == 1)
            return EmployeeStatus.ACTIVE;
        if (integer == 0)
            return EmployeeStatus.IN_ACTIVE;
        if (integer == -1)
            return EmployeeStatus.TERMINATED;
        return null;
    }
}
