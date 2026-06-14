import {Donaciones} from "../models/donaciones.js";


const getDonacionById = (id) => {
    return Donaciones.findByPk(id);
}

const createDonacion = (donacion) => {
    return Donaciones.create(donacion);
}
const updateDonacion = (id, donacion) => {
    return Donaciones.update(donacion, {
        where: { id }
    });
}

const deleteDonacion = (id) => {
    return Donaciones.destroy({
        where: { id }
    });
}

export {
    getDonacionById,
    createDonacion,
    updateDonacion,
    deleteDonacion
}