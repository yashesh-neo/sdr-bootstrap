package sa.bupa.sadirbootstrap.iam.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import sa.bupa.sadirbootstrap.iam.data.AuthorizedPersonModel;
import sa.bupa.sadirbootstrap.iam.data.CustomerModel;
import sa.bupa.sadirbootstrap.iam.data.SdrApplicationModuleModel;
import sa.bupa.sadirbootstrap.iam.data.SdrAuthoritiesModel;
import sa.bupa.sadirbootstrap.iam.data.enumrations.SdrModulePermissions;
import sa.bupa.sadirbootstrap.iam.domain.SdrApplicationModule;
import sa.bupa.sadirbootstrap.iam.domain.SdrAuthority;
import sa.bupa.sadirbootstrap.iam.domain.identities.impl.AuthorizedPerson;
import sa.bupa.sadirbootstrap.iam.domain.identities.impl.Customer;

import java.util.Map;
import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IamMapper {

    IamMapper INSTANCE = Mappers.getMapper(IamMapper.class);

    Map<SdrModulePermissions,String> permissionToCharMap = Map.of(SdrModulePermissions.CREATE,"c",
            SdrModulePermissions.READ,"r",
            SdrModulePermissions.UPDATE,"u",
            SdrModulePermissions.DELETE,"d");

    @Mappings({
            @Mapping(target = "moduleId", source = "authoritiesModel.module.id"),
            @Mapping(target = "accessPattern", expression = "java(mapAuthorityPermissionsToPattern(authoritiesModel.getCreate(), authoritiesModel.getUpdate(), authoritiesModel.getRead(), authoritiesModel.getDelete()))")
    })
    SdrAuthority authorityModelToAuthority(SdrAuthoritiesModel authoritiesModel);

    @Mappings({
            @Mapping(target = "create", expression = "java(patternToDeleteSdrModulePermission(sdrAuthority.getAccessPattern(), sa.bupa.sadirbootstrap.iam.data.enumrations.SdrModulePermissions.CREATE))"),
            @Mapping(target = "read", expression = "java(patternToDeleteSdrModulePermission(sdrAuthority.getAccessPattern(), sa.bupa.sadirbootstrap.iam.data.enumrations.SdrModulePermissions.READ))"),
            @Mapping(target = "update", expression = "java(patternToDeleteSdrModulePermission(sdrAuthority.getAccessPattern(), sa.bupa.sadirbootstrap.iam.data.enumrations.SdrModulePermissions.UPDATE))"),
            @Mapping(target = "delete", expression = "java(patternToDeleteSdrModulePermission(sdrAuthority.getAccessPattern(), sa.bupa.sadirbootstrap.iam.data.enumrations.SdrModulePermissions.DELETE))")
    })
    SdrAuthoritiesModel authorityToAuthorityModel(SdrAuthority sdrAuthority);

    default String mapAuthorityPermissionsToPattern(SdrModulePermissions create, SdrModulePermissions update, SdrModulePermissions read, SdrModulePermissions delete){
        StringBuilder pattern = new StringBuilder();
        if(create!=null){
            pattern.append("c");
        }
        if(read!=null){
            pattern.append("r");
        }
        if(update!=null){
            pattern.append("u");
        }
        if(delete!=null){
            pattern.append("d");
        }
        return pattern.toString();
    }

    default SdrModulePermissions patternToDeleteSdrModulePermission(String pattern, SdrModulePermissions sdrModulePermission) {
        if (null != pattern && pattern.contains(permissionToCharMap.get(sdrModulePermission)))
            return sdrModulePermission;
        return null;
    }

    SdrApplicationModule sdrApplicationModuleModelToSdrApplicationModule(SdrApplicationModuleModel sdrApplicationModuleModel);

    Set<SdrApplicationModule> sdrApplicationModuleModelSetToSdrApplicationModuleSet(Set<SdrApplicationModuleModel> sdrApplicationModuleModelSet);

    SdrApplicationModuleModel sdrApplicationModuleToSdrApplicationModuleModel(SdrApplicationModule sdrApplicationModule);

    Set<SdrApplicationModuleModel> sdrApplicationModuleSetToSdrApplicationModuleModelSet(Set<SdrApplicationModule> sdrApplicationModuleSet);

    AuthorizedPerson authorizedPersonModelToAuthorizedPerson(AuthorizedPersonModel authorizedPersonModel);

    Customer customerModelToCustomer(CustomerModel customerModel);
}
