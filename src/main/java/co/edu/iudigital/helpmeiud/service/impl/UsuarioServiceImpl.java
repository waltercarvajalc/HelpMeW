package co.edu.iudigital.helpmeiud.service.impl;

import co.edu.iudigital.helpmeiud.dto.request.UsuarioDTORequest;
import co.edu.iudigital.helpmeiud.dto.response.UsuarioDTO;
import co.edu.iudigital.helpmeiud.model.Role;
import co.edu.iudigital.helpmeiud.model.Usuario;
import co.edu.iudigital.helpmeiud.repository.IUsuarioRepository;
import co.edu.iudigital.helpmeiud.service.iface.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired // inyección de dependencias por atriubuto
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> consultarTodos() {
        return null;
    }

    @Override
    public UsuarioDTO consultarPorId(Long id) {
        return null;
    }

    @Override
    public UsuarioDTO consultarPorUsername(String username) {
        return null;
    }

    @Override
    public UsuarioDTO guardar(UsuarioDTORequest usuarioDTORequest) {
        Usuario usuario;
        Role role = new Role();
        role.setId(2L);
        usuario = usuarioRepository.findByUsername(usuarioDTORequest.getUsername());
        if(usuario != null){
            return null;
        }
        usuario = new Usuario();
        // convertir usuarioDTORequest a usuario
        usuario.setNombre(usuarioDTORequest.getNombre());
        usuario.setUsername(usuarioDTORequest.getUsername());
        usuario.setApellido(usuarioDTORequest.getApellido());
        usuario.setPassword(usuarioDTORequest.getPassword());
        usuario.setImage(usuarioDTORequest.getImage());
        usuario.setEnabled(true);
        usuario.setRedSocial(false);
        usuario.setRoles(Collections.singletonList(role));
        usuario = usuarioRepository.save(usuario);
        // convertir de usuario a usuarioDTO
        return UsuarioDTO.builder()
                .username(usuario.getUsername())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .enabled(usuario.getEnabled())
                .fechaNacimiento(usuario.getFechaNacimiento())
                .redSocial(usuario.getRedSocial())
                .image(usuario.getImage())
                .roleId(usuario.getRoles().get(0).getId())
                .build();
    }
}
