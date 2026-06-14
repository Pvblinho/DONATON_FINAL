import {tipoUsuarioRepository} from "../repository/tipoUsuarioRepository.js";

const getTipoUsuarioById = (id) => tipoUsuarioRepository.getTipoUsuarioById(id);

const createTipoUsuario = ({nombre}) => {
    validateTipoUsuarioData({nombre});
    return tipoUsuarioRepository.createTipoUsuario({
        nombre: nombre.trim()
    });
};

const updateTipoUsuario = (id, {nombre}) => {
    validateTipoUsuarioData({nombre});
    return tipoUsuarioRepository.updateTipoUsuario(id, {
        nombre: nombre.trim()
    });
};

const deleteTipoUsuario = (id) => {
    validateTipoUsuarioData({nombre: ''});
    return tipoUsuarioRepository.deleteTipoUsuario(id);
};

const validateTipoUsuarioData = ({nombre}) => {
    if (!nombre) {
        throw new Error('El campo nombre es obligatorio');
    }
    if (typeof nombre !== 'string') {
        throw new Error('El campo nombre debe ser de tipo string');
    }
}

export default {
    getTipoUsuarioById,
    createTipoUsuario,
    updateTipoUsuario,
    deleteTipoUsuario,
    validateTipoUsuarioData
}