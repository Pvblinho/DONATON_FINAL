const { DataTypes } = require('sequelize');
const sequelize = require('../config/db');

const Donacion = sequelize.define('Donacion', {
    id: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true
    },
    cantidad: {
        type: DataTypes.DOUBLE,
        allowNull: false
    },
    fechaRecepcion: {
        type: DataTypes.DATE,
        defaultValue: DataTypes.NOW
    },
    centroAcopioId: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    usuarioId: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    categoriaId: {
        type: DataTypes.INTEGER,
        allowNull: false
    }
}, {
    tableName: 'donaciones',
    timestamps: false
});

module.exports = Donacion;