package sa.bupa.sadirbootstrap.iam.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import sa.bupa.sadirbootstrap.iam.data.SdrAuthoritiesModel;
import sa.bupa.sadirbootstrap.iam.data.enumrations.SdrModulePermissions;
import sa.bupa.sadirbootstrap.iam.domain.SdrAuthority;

import java.util.Map;

@Mapper
public interface IamMapper {

    Map<String,SdrModulePermissions> patternToPermissionMap = Map.of("c", SdrModulePermissions.CREATE,
            "r", SdrModulePermissions.READ,
            "u", SdrModulePermissions.UPDATE,
            "d", SdrModulePermissions.DELETE);


    @Mappings({
            @Mapping(target = "accessPattern", expression = "java(mapAuthorityPermissionsToPattern(authoritiesModel.create, authoritiesModel.update, authoritiesModel.read, authoritiesModel.delete))")
    })
    SdrAuthority authorityModelToAuthority(SdrAuthoritiesModel authoritiesModel);


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

    default SdrModulePermissions patternToCreateSdrModulePermission(String pattern){
        if(pattern==null && pattern.contains("c")){
            return SdrModulePermissions.CREATE;
        }
        return null;
    }
    default SdrModulePermissions patternToUpdateSdrModulePermission(String pattern){
        if(pattern==null && pattern.contains("u")){
            return SdrModulePermissions.UPDATE;
        }
        return null;
    }
    default SdrModulePermissions patternToReadSdrModulePermission(String pattern){
        if(pattern==null && pattern.contains("")){
            return SdrModulePermissions.READ;
        }
        return null;
    }
    default SdrModulePermissions patternToDeleteSdrModulePermission(String pattern){
        if(pattern==null && pattern.contains("")){
            return SdrModulePermissions.DELETE;
        }
        return null;
    }


}
