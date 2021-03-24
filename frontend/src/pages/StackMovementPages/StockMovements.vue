<template>
  <div class="stock-movements">
    <h1>
      Movimentações estoque
    </h1>
    <b-card class="mt-2 mb-2">
      <router-link :to="{ name: 'stock-movement' }">
        <b-btn variant="success" id="add" class="mr-2">Efetuar movimentação</b-btn>
      </router-link>
    </b-card>

    <b-card class="mt-4 mb-2">
      <h5 class="mb-3">
        Lista de movimentações estoque
      </h5>
      <table class="table table-hover table-dark">
        <thead>
          <tr>
            <th scope="col">Produto</th>
            <th scope="col">Tipo de movimentação</th>
            <th scope="col">Valor da venda</th>
            <th scope="col">Data da venda</th>
            <th scope="col">Quantidade movimentada</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="stockMovement in stockMovements" :key="stockMovement.id">
            <td>{{stockMovement.product}}</td>
            <td>{{stockMovement.typeMovement}}</td>
            <td>{{stockMovement.sellingValue}}</td>
            <td>{{stockMovement.sellingData}}</td>
            <td>{{stockMovement.quantityMoved}}</td>
          </tr>
        </tbody>
      </table>
    </b-card>
  </div>
</template>

<script>
export default {
  name: 'stock-movements',
  data() {
    return {
      stockMovements: [{
        id: 1,
        product: 'TV',
        typeMovement: 'Entrada',
        sellingValue: 1,
        sellingData: '01/02/2020',
        quantityMoved: 1
      }]
    }
  }
}
</script>