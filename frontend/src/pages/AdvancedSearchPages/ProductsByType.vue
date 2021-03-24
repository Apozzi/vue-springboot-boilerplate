<template>
  <div class="products">
    <h1>
      Consulta de produtos por tipo
    </h1>

    <b-card class="mt-2 mb-2">
      <div class="row">
        <div class="col-md-4">
          <label>Tipo do produto:</label>
          <b-form-select v-model="selected" :options="options"></b-form-select>
        </div>
        <b-btn variant="success" id="add" class="product-by-type__button--filter-spacing ml-2">Filtrar</b-btn>
      </div>
    </b-card>

    <b-card class="mt-4 mb-2">
      <h5 class="mb-3">
        Lista produtos
      </h5>
      <table class="table table-hover table-dark">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Produto</th>
          <th scope="col">Quantidade saída do produto</th>
          <th scope="col">Quantidade disponível</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>TV</td>
          <td>2</td>
          <td>3</td>
        </tr>
      </tbody>
    </table>
    </b-card>
  </div>
</template>

<script>
  export default {
    name: 'products',
    data() {
      return {
        selected: null,
        options: [
          { value: null, text: 'Selecione um tipo de produto', disabled: true },
          { value: 'E', text: 'Eletrônico' },
          { value: 'D', text: 'Eletrodoméstico' },
          { value: 'M', text: 'Movel' },
        ]
      }
    }
  }
</script>

<style scoped>
  .product-by-type__button--filter-spacing {
    margin-top: 31px;
  }
</style>