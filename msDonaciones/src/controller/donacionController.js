import {donacionService} from '../service/donacionService.js';

const getDonacionById = async (req, res) => {
    try {
        const donacion = await donacionService.getDonacionById(req.params.id);
        if (donacion) {
            res.json(donacion);
        } else {
            res.status(404).json({ message: 'Donación no encontrada' });
        }
    } catch (error) {
        res.status(500).json({ message: 'Error al obtener la donación', error });
    }
}

const createDonacion = async (req, res) => {
    try {
        const newDonacion = await donacionService.createDonacion(req.body);
        res.status(201).json(newDonacion);
    } catch (error) {
        res.status(500).json({ message: 'Error al crear la donación', error });
    }
}

const updateDonacion = async (req, res) => {
    try {
        const updatedDonacion = await donacionService.updateDonacion(req.params.id, req.body);
        if (updatedDonacion[0] === 1) {
            res.json({ message: 'Donación actualizada correctamente' });
        } else {
            res.status(404).json({ message: 'Donación no encontrada' });
        }
    } catch (error) {
        res.status(500).json({ message: 'Error al actualizar la donación', error });
    }
}

const deleteDonacion = async (req, res) => {
    try {
        const deleted = await donacionService.deleteDonacion(req.params.id);
        if (deleted) {
            res.json({ message: 'Donación eliminada correctamente' });
        } else {
            res.status(404).json({ message: 'Donación no encontrada' });
        }
    } catch (error) {
        res.status(500).json({ message: 'Error al eliminar la donación', error });
    }
}

export {
    getDonacionById,
    createDonacion,
    updateDonacion,
    deleteDonacion
}