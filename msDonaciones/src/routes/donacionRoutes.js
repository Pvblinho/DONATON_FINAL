import express from 'express';
import db from '../config/db.js';
import verifyToken from '../middleware/auth.js';
import donacionController from '../controllers/donacionController.js';

const router = express.Router();

router.use(verifyToken);

// get /donaciones listar todas las donaciones
router.get('/', donacionController.getAllDonaciones);

//get /donaciones/:id obtener una donacion por id
router.get('/:id', donacionController.getDonacionById);

//post /donaciones crear una nueva donacion
router.post('/', verifyToken, donacionController.createDonacion);

//put /donaciones/:id actualizar una donacion por id
router.put('/:id', verifyToken, donacionController.updateDonacion);

//delete /donaciones/:id eliminar una donacion por id
router.delete('/:id', verifyToken, donacionController.deleteDonacion);

export default router;