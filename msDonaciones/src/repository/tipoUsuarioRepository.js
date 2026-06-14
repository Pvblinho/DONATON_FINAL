import {tipoUsuario} from "../models/tipoUsuario.js";

const getTipoUsuarioById = (id) => {
    return tipoUsuario.findByPk(id);
}

const createTipoUsuario = (tipo) => {
    return tipoUsuario.create(tipo);
}
const updateTipoUsuario = (id, tipo) => {
    return tipoUsuario.update(tipo, {
        where: { id }
    });
}

const deleteTipoUsuario = (id) => {
    return tipoUsuario.destroy({
        where: { id }
    });
}

export {
    getTipoUsuarioById,
    createTipoUsuario,
    updateTipoUsuario,
    deleteTipoUsuario
}