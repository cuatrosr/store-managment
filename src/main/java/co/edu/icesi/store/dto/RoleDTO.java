package co.edu.icesi.store.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoleDTO {

    private String roleName;

    private String roleDescription;

    private List<PermissionDTO> rolePermissions;
}
