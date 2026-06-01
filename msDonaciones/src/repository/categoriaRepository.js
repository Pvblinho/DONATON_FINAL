import { Categorias } from "../models/categorias.js";

const getCategoriaById = (id) => {
    return Categorias.findByPk(id);
}

const createCategoria = (categoria) => {
    return Categorias.create(categoria);
}
const updateCategoria = (id, categoria) => {
    return Categorias.update(categoria, {
        where: { id }
    });
}

const deleteCategoria = (id) => {
    return Categorias.destroy({
        where: { id }
    });
}

export {
    getCategoriaById,
    createCategoria,
    updateCategoria,
    deleteCategoria
}   